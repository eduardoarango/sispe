/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.reniec.sisppe.configuracion;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;


@Configuration
@PropertySource({"classpath:db.properties"})
@ComponentScans(value = {
    @ComponentScan("pe.gob.reniec.sisppe.servicio")})
@MapperScan("pe.gob.reniec.sisppe.dao.mapper")
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource()  {        
         JndiObjectFactoryBean jndiObjectFactoryBean =new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName(env.getProperty("jdbc.url"));
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(DataSource.class);
        try {
            jndiObjectFactoryBean.afterPropertiesSet();
        } catch (IllegalArgumentException | NamingException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (DataSource) jndiObjectFactoryBean.getObject();  //NOT NU
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    } 
    
}

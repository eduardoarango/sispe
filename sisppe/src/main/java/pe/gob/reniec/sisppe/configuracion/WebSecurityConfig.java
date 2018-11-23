/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.reniec.sisppe.configuracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author earango
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
     final Logger logger= LoggerFactory.getLogger(this.getClass());
    
     @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;
   

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {        
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());        
    }

     @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/resources/**").permitAll() // cualquiere link incia con resources tiene acceso
                .antMatchers("/admin/**").hasRole("ADM") // solo el perfil admin
                //.antMatchers("/portal/**").access("hasRole('ADM') and hasRole('GEO')")  /// para mantenimiento solo permiso de adm y geo
                .anyRequest().authenticated()// cualquier otra pagina solo requeire que sea autenticado
                .and()
		.formLogin().loginPage("/login").permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index")                
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .permitAll()                
                .and().csrf().disable()
                .portMapper().http(8080).mapsTo(8443)
                .and().exceptionHandling().accessDeniedPage("/access_denied");
    }
        
}

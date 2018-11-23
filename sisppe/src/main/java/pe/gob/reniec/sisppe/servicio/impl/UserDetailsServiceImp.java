/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.reniec.sisppe.servicio.impl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.reniec.sisppe.dao.mapper.UsuarioMapper;
import pe.gob.reniec.sisppe.dominio.entidades.Usuario;



/**
 *
 * @author earango
 */
@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UsuarioMapper usuarioMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioMapper.findUserByUsername(username);
        logger.info(username + " nu_dni " + passwordEncoder.encode(username));
        logger.info(username + " nu_dni " + passwordEncoder.encode("42537061"));

        logger.info(" acti " + usuario.isEs_registro() + "  exp " + usuario.isEs_expiracion());

        User.UserBuilder builder = null;
        if (usuario != null) {
            if (!usuario.isEs_registro()) {
                throw new BadCredentialsException("Usuario inactivo.");
            } else {
                builder = org.springframework.security.core.userdetails.User.withUsername(username);
                builder.disabled(!usuario.isEs_registro());
                builder.password(usuario.getDe_password());
                String[] authorities = {usuario.getDe_rol()};
                builder.authorities(authorities);
            }

        } else {
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }
        return builder.build();

    }
    /*
     if( usuario == null ){
     // System.out.println("User Not Found");
     logger.error( "User Not Found");
     throw new UsernameNotFoundException( username + " is not found." );
     }

     if( usuario.isEs_registro() == false ){
     // System.out.println("User not enabled");
     logger.error( "User not enabled");
     throw new DisabledException( "User not enabled" );
     }

     if( usuario.isEs_expiracion() == true ){
     //System.out.println("User is Locked");
     logger.error( "User is Locked");
     throw new LockedException( "User is Locked" );
     }
     if( user.isPasswordExpired() == true ){
     // System.out.println("Password Expired");
     logger.error( "Password Expired");
     throw new CredentialsExpiredException( "Password Expired" );
     }  
     */

}

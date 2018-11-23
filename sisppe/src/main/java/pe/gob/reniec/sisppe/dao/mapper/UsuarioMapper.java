/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.reniec.sisppe.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pe.gob.reniec.sisppe.dominio.entidades.Usuario;

/**
 *
 * @author earango
 */
public interface UsuarioMapper {
    
    @Select("")
    public List<Usuario> listarUsuario();

    @Select("SELECT usu.NU_DNI,usu.DE_CORREO,usu.DE_NOMBRE,usu.DE_PASSWORD,rol.DE_ROL_ABREVIATURA as de_rol,usu.es_registro FROM IDOGEO.GCTM_USUARIO usu join IDOGEO.GCTM_ROLES rol on usu.co_rol=rol.CO_ROL where NU_DNI=#{username}")
    public Usuario findUserByUsername(@Param("username") String username);
    
}

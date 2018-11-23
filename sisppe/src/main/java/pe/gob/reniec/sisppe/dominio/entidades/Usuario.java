/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.reniec.sisppe.dominio.entidades;

/**
 *
 * @author earango
 */
public class Usuario {
    private String nu_dni;
    private String de_nombre;
    private String es_tipo_usuario;
    private String de_password;
    private String de_correo;
    private String de_rol;
    private boolean es_registro;
    private boolean es_expiracion;
    private int co_rol;

    /**
     * @return the nu_dni
     */
    public String getNu_dni() {
        return nu_dni;
    }

    /**
     * @param nu_dni the nu_dni to set
     */
    public void setNu_dni(String nu_dni) {
        this.nu_dni = nu_dni;
    }

    /**
     * @return the de_nombre
     */
    public String getDe_nombre() {
        return de_nombre;
    }

    /**
     * @param de_nombre the de_nombre to set
     */
    public void setDe_nombre(String de_nombre) {
        this.de_nombre = de_nombre;
    }

    /**
     * @return the es_tipo_usuario
     */
    public String getEs_tipo_usuario() {
        return es_tipo_usuario;
    }

    /**
     * @param es_tipo_usuario the es_tipo_usuario to set
     */
    public void setEs_tipo_usuario(String es_tipo_usuario) {
        this.es_tipo_usuario = es_tipo_usuario;
    }

    /**
     * @return the de_password
     */
    public String getDe_password() {
        return de_password;
    }

    /**
     * @param de_password the de_password to set
     */
    public void setDe_password(String de_password) {
        this.de_password = de_password;
    }

    /**
     * @return the de_correo
     */
    public String getDe_correo() {
        return de_correo;
    }

    /**
     * @param de_correo the de_correo to set
     */
    public void setDe_correo(String de_correo) {
        this.de_correo = de_correo;
    }

    /**
     * @return the de_rol
     */
    public String getDe_rol() {
        return de_rol;
    }

    /**
     * @param de_rol the de_rol to set
     */
    public void setDe_rol(String de_rol) {
        this.de_rol = de_rol;
    }

    /**
     * @return the es_registro
     */
    public boolean isEs_registro() {
        return es_registro;
    }

    /**
     * @param es_registro the es_registro to set
     */
    public void setEs_registro(boolean es_registro) {
        this.es_registro = es_registro;
    }

    /**
     * @return the es_expiracion
     */
    public boolean isEs_expiracion() {
        return es_expiracion;
    }

    /**
     * @param es_expiracion the es_expiracion to set
     */
    public void setEs_expiracion(boolean es_expiracion) {
        this.es_expiracion = es_expiracion;
    }

    /**
     * @return the co_rol
     */
    public int getCo_rol() {
        return co_rol;
    }

    /**
     * @param co_rol the co_rol to set
     */
    public void setCo_rol(int co_rol) {
        this.co_rol = co_rol;
    }
}

package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;

@Entity
public class Usuario {
    @Id
    @SequenceGenerator(name="Usuario_ID_GENERATOR", sequenceName="Usuario_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Usuario_ID_GENERATOR")
    public Integer ID_usuario;
    public String NombreCompleto;
    public String Correo;
    private String Password;
    private Boolean Activo;

    
    

    public Usuario(){}

    public Usuario(String nombrecompleto, String correo, String password, Boolean activo){
        this.NombreCompleto = nombrecompleto;
        this.Correo = correo;
        this.Password = password;
        this.Activo=activo;
    }

    

    public Integer getId_usuario() {
        return ID_usuario;
    }

    public void setNombreCompleto(String nombrecompleto) {
        this.NombreCompleto = nombrecompleto;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setCorreo(String correo) {
        this.Correo = correo;
    }

    public String getCorreo() {
        return Correo;
    }


    public void setPassword(String password) {
        this.Password = password;
    }

    public String getPassword() {
        return Password;
    }
    
    
    public void setActivo(Boolean activo){
        this.Activo = activo;
    }

    public Boolean getActivo(){
        return this.Activo;
    }


  
}

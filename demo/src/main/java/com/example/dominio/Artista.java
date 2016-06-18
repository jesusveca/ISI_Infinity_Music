package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
public class Artista {
    @Id
    @SequenceGenerator(name="Artista_ID_GENERATOR", sequenceName="Artista_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Artista_ID_GENERATOR")
    public Integer ID_artista;
    public String Nombre;
    private Boolean Activo;

    
    	
    
    public Artista(){}

    public Artista(String nombre, Boolean activo){
        this.Nombre = nombre;
        this.Activo =activo;
    }
    
    
    
    public Integer getId_artista() {
        return ID_artista;
    }

    public void setNombre(String nombre){
        this.Nombre = nombre;
    }

    public String getNombre(){
        return this.Nombre;
    }

    
    
    
    public void setActivo(Boolean activo){
        this.Activo = activo;
    }

    public Boolean getActivo(){
        return this.Activo;
    }
    
    

}
package com.example.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Playlist {
    @Id
    @SequenceGenerator(name="Playlist_ID_GENERATOR", sequenceName="Playlist_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Playlist_ID_GENERATOR")
    public Integer ID_playlist;
    public Integer id_usuario;
    public String Nombre;

    public Playlist(){}

    public Playlist(String nombre, Integer id_usuario){
        this.Nombre=nombre;
        this.id_usuario=id_usuario;

    }
    
    
    
    
    
    public Integer getID_playlist() {
        return ID_playlist;
    }

    public void setId_Usuario(Integer usuario) {
        this.id_usuario = usuario;
    }

    public Integer getUsuario() {
        return id_usuario;
    }

    public void setNombre(String nombre){
    	this.Nombre=nombre;
    }
    
    public String getNombre(){
    	return Nombre;
    	
    }
    


}

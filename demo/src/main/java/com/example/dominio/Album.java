package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import java.util.Date;


@Entity
public class Album {
	@Id
	@SequenceGenerator(name = "Album_ID_GENERATOR", sequenceName = "Album_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Album_ID_GENERATOR")
	
//	@ManyToOne
//	@JoinColumn(name="ID_artista")
	public String Artistas; // public Artista Artistas;
	public Integer ID_album;
	private Date Fecha;
	public String Nombre;

	private Boolean Activo;
	

	public Album(){}
	
    public Album (Date fecha, String nombre, String artista, Boolean Activo){
        this.Nombre = nombre;
        this.Artistas = artista;
        this.Fecha = fecha;
        this.Activo=Activo;
    }
	
	
    
    public Integer getId_album() {
        return ID_album;
    }

    public void setNombre(String nombre){
        this.Nombre = nombre;
    }

    public String getNombre(){
        return this.Nombre;
    }

    public void setArtista(String artistas) {
        this.Artistas = artistas;
    }

    public String getArtistas() {
        return Artistas;
    }

    public void setFecha(Date fecha){
        this.Fecha = fecha;
    }

    public Date getFecha(){
        return this.Fecha;
    }
    
    public void setActivo(Boolean activo){
        this.Activo = activo;
    }

    public Boolean getActivo(){
        return this.Activo;
    }
    
    
}

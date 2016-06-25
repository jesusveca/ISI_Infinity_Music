package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Artista {
    @Id
    @SequenceGenerator(name="Artista_ID_GENERATOR", sequenceName="Artista_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Artista_ID_GENERATOR")
    private Integer id_artista;
    private String nombre;
    private Boolean activo;

    @ManyToMany
	@JoinTable(name = "Artista_Cancion",
		joinColumns = @JoinColumn(name = "ID_ARTISTA", referencedColumnName = "id_artista"),
		inverseJoinColumns = @JoinColumn(name = "ID_CANCION", referencedColumnName = "id_cancion"))
	private List<Cancion> canciones;
	@ManyToMany
	@JoinTable(name = "Artista_Album",
		joinColumns = @JoinColumn(name = "ID_ARTISTA", referencedColumnName = "id_artista"),
		inverseJoinColumns = @JoinColumn(name = "ID_ALBUM", referencedColumnName = "id_album"))
	private List<Album> albums;

	public Integer getId_artista() {
        return id_artista;
    }

    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
    
    
    
    public void setActivo(boolean activo){
        this.nombre = nombre;
    }

    public boolean getActivo(){
        return this.activo;
    }
    
    

    public Artista(){}

    public Artista(String nombre){
        this.nombre = nombre;
    }
    
	public Artista(String nombre,List<Cancion> canciones,List<Album> albums) {
		this.nombre = nombre;		
		this.canciones = canciones;
		this.albums = albums;
	}
	public List<Album> getAlbumes(){
		return this.albums;
	}
	


	public List<Cancion> getCanciones() {
		return this.canciones;	
	}
	
    
    
}
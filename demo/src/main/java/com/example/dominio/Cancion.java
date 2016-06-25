package com.example.dominio;
import javax.persistence.*;
import java.util.List;
import java.util.Date;

@Entity
public class Cancion {
    @Id
    @SequenceGenerator(name="Cancion_ID_GENERATOR", sequenceName="Cancion_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Cancion_ID_GENERATOR")
    private Integer id_cancion;
    private String nombre;
    private Boolean activo;
    private String letra;
    private Date fecha;
    

    @ManyToMany(mappedBy = "canciones")
    private List<Playlist> playlistsTopTen;

 
    @ManyToOne
    @JoinColumn(name="ID_ARTISTA")
    private Artista artista;
    

    
    @ManyToOne
    @JoinColumn(name = "ID_ALBUM")
    private Album album;


    
    private Integer puntuacion;
    private Integer reproducciones;

    
    
    public void modificar_puntuacion(Integer puntos){
    		this.puntuacion=puntuacion+puntos;
    }
    
    public void setTitulo(String nombre){
        this.nombre = nombre;
    }

    public String getTitulo(){
        return this.nombre;
    }

    public Integer getId_cancion(){
        return this.id_cancion;
    }


    public void setAlbum(Album album) {
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }

    
    
    public void setActivo(Boolean activo){
        this.activo = activo;
    }

    public Boolean getActivo(){
        return this.activo;
    }

    
    


    public void setPuntuacion(Integer puntuacion){
        this.puntuacion = puntuacion;
    }

    public Integer getPuntuacion(){
        return this.puntuacion;
    }

    public void setReproducciones(Integer reproducciones){
        this.reproducciones= reproducciones;
    }

    public Integer getReproducciones(){
        return this.reproducciones;
    }
    public Cancion(){}

    public Cancion(String nombre, Album album, Date fecha, Boolean activo){
        this.nombre = nombre;
        this.album = album;
        this.fecha = fecha;
        this.activo =activo;
    }
}
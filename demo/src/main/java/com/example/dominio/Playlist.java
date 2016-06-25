package com.example.dominio;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.List;

@Entity
public class Playlist {
    @Id
    @SequenceGenerator(name="Playlist_ID_GENERATOR", sequenceName="Playlist_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Playlist_ID_GENERATOR")
    private Integer id_playlist;

    
    
    //Muchas playlist pertenecen a un usuario
    // podria ser que muchos playlist a muchos usuarios (sin embargo los otros usuarios no son duenos, pero si la reproducen)
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    
    private String nombre;
    private Date fecha;

    @ManyToMany
    @JoinTable(name = "playlist_cancion", 
    	joinColumns = @JoinColumn(name = "ID_PLAYLIST", referencedColumnName = "id_playlist"), 
    	inverseJoinColumns = @JoinColumn(name = "ID_CANCION", referencedColumnName= "id_cancion"))
    private List<Cancion> canciones;



    
    
    
    private Integer seguidores;
    private Integer puntuacion;

    public Integer getId_playlist() {
        return id_playlist;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void addCancion(Cancion cancion){//no se si debo hacerlos a travez de esto, o a travez  get canciones y a l resulado hacer esta operacion, revisar si funciona despues
        this.canciones.add(cancion);
    }

    public void deleteCancion(Cancion cancion){
        this.canciones.remove(cancion);
    }

    public void setSeguidores(Integer seguidores) {
        this.seguidores = seguidores;
    }

    public Integer getSeguidores() {
        return seguidores;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public Playlist (Usuario user, String nombre2){
        this.usuario = user;
        this.nombre = nombre2;    	
    }
    
    
	public void agregarCancion(Cancion cancion){
		canciones.add(cancion);
		return;
	}
    
	
	public void BorrarCancion(Cancion cancion){
		canciones.remove(cancion);
		return;
	}
    
	
	
	public boolean buscarCancion(Cancion cancion){
		for(int i = 0; i < canciones.size(); i++){
			if(canciones.get(i) == cancion){
				return true;
			}
		}
		return false;
	}
	
}

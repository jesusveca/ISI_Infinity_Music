package com.example.dominio;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Album {
    @Id
    @SequenceGenerator(name="Album_ID_GENERATOR", sequenceName="Album_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Album_ID_GENERATOR")
    private Integer id_album;
    private String nombre;
    
    private Date fecha;
    private Boolean activo;


    @OneToMany(mappedBy = "album")
    private List<Cancion> canciones;
    
    @ManyToOne
    @JoinColumn(name="id_artista")
//    private List<Artista> artistas;
    private Artista artista;
    
    
	public List<Cancion> getCancionesAlbum(){
		return this.canciones;
	}
    
    
	
	public boolean buscarCancionAlbum(Cancion cancion){
		for(int i = 0; i < canciones.size(); i++){
			if(canciones.get(i) == cancion){
				return true;
			}
		}
		return false;
	}
    
    
    
    public Integer getId_album() {
        return id_album;
    }

    public void setTitulo(String nombre){
        this.nombre = nombre;
    }

    public String getTitulo(){
        return this.nombre;
    }

    
    public void setActivo(Boolean activo){
        this.activo = activo;
    }

    public Boolean getActivo(){
        return this.activo;
    }
    
    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Artista getArtista() {
        return artista;
    }


    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public Date getFecha(){
        return this.fecha;
    }

    
    public Album (){}

    public Album (String nombre, Artista artista, Date fecha,Boolean activo){
        this.nombre = nombre;
        this.artista = artista;
        this.fecha = fecha;
        this.activo=activo;
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
package com.example.servicio;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dominio.Album;
import com.example.dominio.Artista;
import com.example.dominio.Cancion;
import com.example.dominio.Playlist;
import com.example.dominio.Usuario;
import com.example.repositorio.AdministradorRepositorio;
import com.example.repositorio.AlbumRepositorio;
import com.example.repositorio.ArtistaRepositorio;
import com.example.repositorio.CancionRepositorio;
import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Service
public class AdministradorServiceImpl implements AdministradorService {

	AdministradorRepositorio administradorRepositorio;
	ArtistaRepositorio artistaRepositorio;
	AlbumRepositorio albumRepositorio;
	CancionRepositorio cancionRepositorio;
	
	@Autowired
	public AdministradorServiceImpl(AdministradorRepositorio ar, ArtistaRepositorio arr, AlbumRepositorio alr){
		this.administradorRepositorio = ar;
		this.artistaRepositorio = arr;
		this.albumRepositorio = alr;
	}
	


    @Transactional
    @Override
    public boolean agregarArtista(String nombre){
    	Artista artista = new Artista(nombre);
    	return true;
    }

    
    
	@Transactional
	@Override
	public void agregarAlbum(Boolean activo, Date fecha, String nombre, Integer id_artista){
        Artista artista = artistaRepositorio.findOne(id_artista);
        Album album = new Album();
        album.setArtista(artista);
        album.setTitulo(nombre);
        album.setFecha(fecha);
        album.setActivo(activo);
        albumRepositorio.save(album);
	}
	
	
	
    @Override
    public void eliminarAlbum(Integer id_album){
        Album album = albumRepositorio.findOne(id_album);
        albumRepositorio.delete(album);
        albumRepositorio.delete(id_album);
    }
    
    
    @Override
    public boolean agregarCancionToAlbum(Integer id_usuario,Integer id_album,Integer id_cancion){
		Album album = albumRepositorio.findOne(id_album);
		Cancion cancion = cancionRepositorio.findOne(id_cancion);
		if(album.buscarCancion(cancion))		return false;
		else { 
			album.agregarCancion(cancion);
			return true;
		}
    }
    
    @Override
    public boolean eliminarCancionDeAlbum(Integer id_cancion,Integer id_album){
		Album album = albumRepositorio.findOne(id_album);
		Cancion cancion = cancionRepositorio.BuscarCancionByID(id_cancion);
		if(album != null) {
			album.BorrarCancion(cancion);
			return true;
		}
		return false;
    }
    
    
    @Override
    public boolean bloquearAlbum(Integer id_album){
    	Album album = albumRepositorio.findOne(id_album);
    	boolean desactivo=false;
    	album.setActivo(desactivo);
    	return true;
    }
   
    
    @Override
    public boolean bloquearCancion(Integer id_cancion){
    	Cancion cancion = cancionRepositorio.findOne(id_cancion);
    	boolean desactivo=false;
    	cancion.setActivo(desactivo);
    	return true;
    }
    
    
    @Override
    public boolean bloquearArtista(Integer id_artista){
    	Artista artista = artistaRepositorio.findOne(id_artista);
    	boolean desactivo=false;
    	artista.setActivo(desactivo);
    	return true;
    }
   
    
    
    @Override
    public boolean desbloquearAlbum(Integer id_album){
    	Album album = albumRepositorio.findOne(id_album);
    	boolean activar=true;
    	album.setActivo(activar);
    	return true;
    }
   
    
    @Override
    public boolean desbloquearCancion(Integer id_cancion){
    	Cancion cancion = cancionRepositorio.findOne(id_cancion);
    	boolean activar=true;
    	cancion.setActivo(activar);
    	return true;
    }
    
    
    @Override
    public boolean desbloquearArtista(Integer id_artista){
    	Artista artista = artistaRepositorio.findOne(id_artista);
    	boolean activar=true;
    	artista.setActivo(activar);
    	return true;
    }
   
    
    
    

}
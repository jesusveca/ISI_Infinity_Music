package com.example.servicio;

import java.util.List;

import com.example.dominio.Album;
import com.example.dominio.Artista;
import com.example.dominio.Cancion;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public interface AdministradorService {

	boolean agregarArtista(String nombre );
	void agregarAlbum(Boolean activo, Date fecha, String nombre, Integer id_artista);
	boolean agregarCancionToAlbum(Integer id_usuario,Integer id_album,Integer id_cancion);
	boolean eliminarCancionDeAlbum(Integer id_cancion,Integer id_album);

	void eliminarAlbum(Integer id_album);
    
	boolean bloquearAlbum(Integer id_album);
	boolean bloquearCancion(Integer id_cancion);
	boolean bloquearArtista(Integer id_artista);
	
	
	boolean desbloquearAlbum(Integer id_album);
	boolean desbloquearCancion(Integer id_cancion);
	boolean desbloquearArtista(Integer id_artista);
	
	
}
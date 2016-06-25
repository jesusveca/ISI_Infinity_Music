package com.example.repositorio;

import java.util.List;

import com.example.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dominio.Cancion;
import com.example.dominio.Playlist;
import com.example.dominio.Usuario;



public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
    List<Usuario> findAll();
    Usuario findOne(Integer id_usuario);
    
	@Query("SELECT c FROM Playlist AS c WHERE nombre_playlist = :nombre AND usuario_id = :usuario_id")
	Playlist BuscarPlaylist(String nombre, Integer usuario_id); // Usuario id_usuario
	
	@Query("SELECT c FROM Cancion AS c WHERE nombre_cancion = :nombre")
	Cancion Buscar_Cancion(String nombre);
	
	@Query("SELECT c FROM Playlist AS c WHERE id_playlist = :id_playlist")
	Playlist BuscarPlaylistByID(Integer id_playlist); // Usuario id_usuario
	
    
	@Query("SELECT c FROM Usuario AS c WHERE id_usuario = :id_usuario")
	Usuario BuscarUsuarioByID(Integer id_usuario); // Usuario id_usuario
	
	@Query("SELECT c FROM Usuario AS c WHERE nombre_completo = :username")
	Usuario BuscarUsuarioByUsername(String username); // Usuario id_usuario
	

	@Query("SELECT c FROM Cancion AS c WHERE nombre = :nombre")
	Usuario BuscarCancionByNombre(String nombre); // Usuario id_usuario
	
	@Query("SELECT c FROM Playlist AS c WHERE titulo = :titulo")
	Usuario BuscarPlaylistByNombre(String titulo); // Usuario id_usuario
	
	
	
}
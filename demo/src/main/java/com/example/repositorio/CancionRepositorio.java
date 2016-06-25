package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.dominio.Cancion;
import com.example.dominio.Playlist;

public interface CancionRepositorio extends CrudRepository<Cancion, Integer>{
    List<Cancion> findAll();
    Cancion findOne(Integer id_cancion);
    
    
	@Query("SELECT c FROM Cancion AS c WHERE id_cancion = :id_cancion")
	Cancion BuscarCancionByID(Integer id_cancion); // Usuario id_usuario
	
}
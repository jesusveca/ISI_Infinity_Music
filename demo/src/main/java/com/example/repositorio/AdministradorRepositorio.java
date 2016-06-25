package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.dominio.Administrador;
import com.example.dominio.Album;
import com.example.dominio.Artista;

public interface AdministradorRepositorio extends CrudRepository<Administrador, Integer> {
	List<Administrador> findAll();
	//boolean saveArtista(Artista artista);
	//boolean saveAlbum(Album album);
	@Query("DELETE FROM Artista c WHERE c.id_artista = :Id")
	boolean deleteArtista(Integer id_artista);
	//bool Agregar_Artista(Artista artita);
	//bool Agregar_Album(Album Album);
	//bool Eliminar_Artista(Artista artista);
	//bool Eliminar_Album(Album Album);
}
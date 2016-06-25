//package com.example.repositorio;
//
//import java.util.List;
//import org.springframework.data.repository.CrudRepository;
//import com.example.dominio.Album;
//
//public interface AlbumRepositorio extends CrudRepository<Album, Integer>{
//    List<Album> findAll();
//    Album findOne(Integer id_album);
//}


package com.example.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.dominio.Album;

public interface AlbumRepositorio extends CrudRepository<Album, Integer>{
    List<Album> findAll();
    Album findOne(Integer id_album);
    @Query("select al from Album al where al.nombre = :nombre")
    Album buscarPorTitulo(String titulo);
    
    
    
}
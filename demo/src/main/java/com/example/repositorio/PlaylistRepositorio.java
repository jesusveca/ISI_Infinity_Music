package com.example.repositorio;

import java.util.List;

import com.example.dominio.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepositorio extends CrudRepository<Playlist, Integer>{
    List<Playlist> findAll();
    Playlist findOne(Integer id_playlist);
}

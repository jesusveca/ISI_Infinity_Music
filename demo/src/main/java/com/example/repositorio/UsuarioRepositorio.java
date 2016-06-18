package com.example.repositorio;

import java.util.List;

import com.example.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
    List<Usuario> findAll();
    Usuario findOne(Integer id_usuario);
}

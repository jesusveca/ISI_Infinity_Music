package com.example.servicio;

import java.util.Date;

public interface UsuarioService {
    boolean crearPlaylist(Integer id_usuario, String titulo);
    boolean agregarCancionToPlaylist(Integer id_usuario,Integer id_playlist,Integer id_cancion);
    void eliminarPlaylist(Integer id_playlist);
    
    
    void eliminarCancionDePlaylist(Integer id_cancion,Integer id_playlist);
    
    
    
    //implementar para cuando se desea modificar playlist
    //boolean crearPlaylist(Integer id_usuario, String titulo);
    
    boolean seguirToUsuario(Integer id_usuario_seguidor,Integer id_usuario2_seguido);
    boolean dejarSeguirToUsuario(Integer id_usuario_seguidor,Integer id_usuario2_seguido);
    
    boolean buscarUsuarioById (Integer id_usuario);
    boolean buscarUsuarioByUsername (String username);
    boolean buscarCancionByNombre (String nombre);
    boolean buscarPlaylistByNombre (String nombre);
    
    
    boolean agregarHistorialCanciones(Integer id_cancion,Integer id_usuario);
    
    void calificarCancion(Integer id_cancion, Integer puntos);
    
    //registrarse 
    void agregarUsuario(String username, String password, String email, String nombre, Date fecha_nacimiento);
    void modificarUsuario(Integer id_usuario,String username, String password, String email, String nombre, Date fecha_nacimiento);
    
    void eliminarUsuario(Integer id_usuario);
    
    //necesito id_usuario para saber si esta logeado o no ,
    //necesito id_album para saber de que album sacara las canciones
    boolean reproducirCancionFromAlbum(Integer id_usuario,Integer id_album,Integer id_cancion);
    
}

// Servicio de cancion solo tendria a lo maximo un contador. 


// matricular relaciona : cursos y alumno 


// agregar cancion relaciona : usuario y cancion 


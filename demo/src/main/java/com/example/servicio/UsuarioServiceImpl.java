package com.example.servicio;

import java.util.Date;

import com.example.dominio.Playlist;
import com.example.dominio.Usuario;
import com.example.dominio.Cancion;
import com.example.dominio.Album;
import com.example.repositorio.PlaylistRepositorio;
import com.example.repositorio.UsuarioRepositorio;
import com.example.repositorio.CancionRepositorio;
import com.example.repositorio.AlbumRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    UsuarioRepositorio usuarioRepositorio;
    PlaylistRepositorio playlistRepositorio;
    CancionRepositorio cancionRepositorio;

    AlbumRepositorio albumRepositorio;

    @Autowired
    public UsuarioServiceImpl (UsuarioRepositorio ur){
        this.usuarioRepositorio = ur;
    }

    @Transactional
    @Override
    public void agregarUsuario(String username, String password, String email, String nombre,Date fecha_nacimineto){
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuario.setNombre(nombre);
        usuario.setFechaNacimiento(fecha_nacimineto);
        usuario.setFechaCreacion(new Date());
        usuarioRepositorio.save(usuario);
    }


    @Transactional
    @Override
    public void modificarUsuario(Integer id_usuario, String username, String password, String email, String nombre,Date fecha_nacimineto){
        
		Usuario user = usuarioRepositorio.BuscarUsuarioByID(id_usuario);
        if (user!=null){
        	user.setUsername(username);
        	user.setPassword(password);
        	user.setEmail(email);
        	user.setNombre(nombre);
        	user.setFechaNacimiento(fecha_nacimineto);
	        user.setFechaCreacion(new Date());
	        usuarioRepositorio.save(user);
        }
        
    }

    
    @Transactional
    @Override
    public void eliminarUsuario(Integer id_usuario){
        Usuario usuario = usuarioRepositorio.findOne(id_usuario);
        usuarioRepositorio.delete(usuario);
    }
    
    
    @Transactional
    @Override
    public void eliminarPlaylist(Integer id_playlist){
    	Playlist playlist = playlistRepositorio.findOne(id_playlist);
        playlistRepositorio.delete(playlist);
    }
    
    @Transactional
    @Override
    public void eliminarCancionDePlaylist(Integer id_cancion,Integer id_playlist){
		Playlist playlist = usuarioRepositorio.BuscarPlaylistByID(id_playlist);
		Cancion cancion = cancionRepositorio.BuscarCancionByID(id_cancion);
		if(playlist != null) {
			playlist.BorrarCancion(cancion);
		}
    }
    
   
    
    @Transactional
    @Override
    public boolean crearPlaylist(Integer id_usuario, String nombre){
        
		Playlist playlist = usuarioRepositorio.BuscarPlaylist(nombre, id_usuario);
		if(playlist != null) return false;
		else{
			Usuario usuario = usuarioRepositorio.findOne(id_usuario);
			playlist = new Playlist(usuario,nombre);
			playlistRepositorio.save(playlist);
			return true;
		}
    }
    
    @Transactional
    @Override
    public boolean agregarCancionToPlaylist(Integer id_usuario,Integer id_playlist,Integer id_cancion){
		Playlist playlist = usuarioRepositorio.BuscarPlaylistByID(id_playlist);
		Cancion cancion = cancionRepositorio.BuscarCancionByID(id_cancion);
		if(playlist.buscarCancion(cancion))		return false;
		else { 
			playlist.agregarCancion(cancion);
			return true;
		}
    }
    
    @Transactional
	@Override
	public boolean seguirToUsuario(Integer id_usuario_seguidor,Integer id_usuario_seguido) {
		Usuario seguidor = usuarioRepositorio.findOne(id_usuario_seguidor);
		Usuario usuarioASeguir = usuarioRepositorio.findOne(id_usuario_seguido);
		if(seguidor.buscarToSeguir(seguidor.getSiguiendo(), usuarioASeguir) != null) 
			return false;
		else{
			seguidor.agregarSeguidor(usuarioASeguir);
			return true;
		}
	}
    @Transactional
	@Override
	public boolean dejarSeguirToUsuario(Integer id_usuario_seguidor,Integer id_usuario_seguido) {
		Usuario seguidor = usuarioRepositorio.findOne(id_usuario_seguidor);
		Usuario usuarioASeguir = usuarioRepositorio.findOne(id_usuario_seguido);
		if(seguidor.buscarToSeguir(seguidor.getSiguiendo(), usuarioASeguir) != null) 
			return false;
		else{
			seguidor.borrarToSeguir(usuarioASeguir);
			return true;
		}
	}

    @Transactional
	@Override
	public boolean reproducirCancionFromAlbum(Integer id_usuario,Integer id_album,Integer id_cancion){
		Usuario user = usuarioRepositorio.BuscarUsuarioByID(id_usuario);
		Cancion cancion = cancionRepositorio.BuscarCancionByID(id_cancion);
		Album album=albumRepositorio.findOne(id_album);
		//comprobar si usuario esta logeado
		if (user!=null){
			
			//comprobar si la cancion a reproducir esta en el album
			if(album.buscarCancionAlbum(cancion)==true){
				
				//por ahora solo retornar true cuando pongo 'play'
				return true;
				
			}
			else 
				return false;
		}
		return false;
	}
    
    
    
    @Transactional
    @Override
	public boolean buscarUsuarioById (Integer id_usuario){
		Usuario user = usuarioRepositorio.BuscarUsuarioByID(id_usuario);
		if (user!=null){
			return true;
		}
		else {
			return false;
		}
	}
    
    
    
    @Transactional
    @Override
	public boolean buscarUsuarioByUsername (String username){
		Usuario user = usuarioRepositorio.BuscarUsuarioByUsername(username);
		if (user!=null){
			return true;
		}
		else {
			return false;
		}
	}
    
    @Transactional
    @Override
	public boolean buscarCancionByNombre (String nombre){
		Usuario user = usuarioRepositorio.BuscarCancionByNombre(nombre);
		if (user!=null){
			return true;
		}
		else {
			return false;
		}
	}
    
    @Transactional
    @Override
	public boolean buscarPlaylistByNombre (String nombre){
		Usuario user = usuarioRepositorio.BuscarPlaylistByNombre(nombre);
		if (user!=null){
			return true;
		}
		else {
			return false;
		}
	}
    
    @Override
    public void calificarCancion(Integer id_cancion,Integer puntos){
		Cancion cancion = cancionRepositorio.BuscarCancionByID(id_cancion);
		if(cancion!=null){
			cancion.modificar_puntuacion(puntos);
		}	
    }
    
    
    
    @Override
    public boolean agregarHistorialCanciones(Integer id_cancion,Integer id_usuario){
		Usuario user = usuarioRepositorio.findOne(id_usuario);
		Cancion cancion=cancionRepositorio.findOne(id_cancion);
		if (user!=null){
			user.agregarHistorial(cancion);
			return true;
		}
    	return false;
    }
    
    
    

}
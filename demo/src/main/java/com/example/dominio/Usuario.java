package com.example.dominio;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @SequenceGenerator(name="Usuario_ID_GENERATOR", sequenceName="Usuario_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Usuario_ID_GENERATOR")
    private Integer id_usuario;
    private String username;
    private String password;
    private String email;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    
    private Boolean activo;

    
	@ManyToMany
	@JoinTable(name = "seguidores_user",
		joinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "id_usuario"),
		inverseJoinColumns = @JoinColumn(name = "ID_SEGUIDOR",  referencedColumnName = "id_usuario"))
	private List<Usuario> Seguidores;

	
	@ManyToMany
	@JoinTable(name = "siguiendo_user",
		joinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "id_usuario"),
		inverseJoinColumns = @JoinColumn(name = "ID_SEGUIDOR", referencedColumnName = "id_usuario"))
	public List<Usuario> Siguiendo;
    

	
	@ManyToMany
	@JoinTable(name = "historial_usuario_canciones",
		joinColumns = @JoinColumn(name = "ID_USUARIO", referencedColumnName = "id_usuario"),
		inverseJoinColumns = @JoinColumn(name = "ID_CANCION", referencedColumnName = "id_cancion"))
	public List<Cancion> historialTimeline;
    
	
	public List<Cancion> getHistorial(){
		return this.historialTimeline;
	}
	
	public void agregarHistorial(Cancion id_cancion){
		historialTimeline.add(id_cancion);
	}
	
	
	
	public List<Usuario> getSiguiendo(){
		return this.Siguiendo;
	}
	public List<Usuario> getSeguidores(){
		return this.Seguidores;
	}
	
	
	
    
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombreCompleto = nombre;
    }

    public String getNombre() {
        return nombreCompleto;
    }



    public void setFechaNacimiento(Date fecha_nacimiento) {
        this.fechaNacimiento = fecha_nacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }



    public void setFechaCreacion(Date fecha_creacion) {
        this.fechaCreacion = fecha_creacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    
    
	public Usuario buscarToSeguir(List<Usuario> usuarios, Usuario usuario){
		for(Usuario i : usuarios){
			if(i == usuario) return usuario;
		}
		return null;
	}
	
	
	
	
	public void borrarToSeguir(Usuario usuario){
		int t = 0;
		for(int i = 0; i < Siguiendo.size(); i++){
			if(Siguiendo.get(i) == usuario) {
				t = i;
			}
		}
		Siguiendo.remove(t);
	}
	public void agregarSeguidor(Usuario usuario){
		Siguiendo.add(usuario);
	}
    
    

    public void setCerrarCuenta(Boolean activo) {
        this.activo = activo;
    }

    public Boolean getCerrarCuenta() {
        return activo;
    }
	
	
	
    
    public Usuario(){}

    public Usuario(String username, String password, String email, String nombre, String apellido, Date fecha_nacimineto, String path_foto_perfil){
        this.username = username;
        this.password = password;
        this.email = email;
        this.nombreCompleto = nombre;
        this.fechaNacimiento = fecha_nacimineto;
        this.fechaCreacion = new Date();
    }
}
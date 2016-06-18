package com.example.dominio;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cancion {
    @Id
    @SequenceGenerator(name="Cancion_ID_GENERATOR", sequenceName="Cancion_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Cancion_ID_GENERATOR")
    public Integer ID_cancion;
    public String Nombre;
    public String Autor;
    public Integer AlbumPerteneciente;
    public Integer PuntuacionPromedio;
    public Date Fecha;
    public String Letra;
    public Boolean Activo;
    
    
    
    public Cancion(){}

    public Cancion(String nombre, String autor, Integer albumperteneciente, Integer puntuacion, Date fecha,String letra,Boolean activo){
        this.Nombre=nombre;
        this.Autor=autor;
        this.AlbumPerteneciente=albumperteneciente;
        this.PuntuacionPromedio=puntuacion;
        this.Fecha=fecha;
        this.Letra=letra;
        this.Activo=activo;

    }
    
    
    public Integer getID_cancion(){
        return this.ID_cancion;
    }
    
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }

    public String getNombre(){
        return this.Nombre;
    }

    public void setAutor(String autor){
        this.Autor = autor;
    }

    public String getAutor(){
        return this.Autor;
    }



    public void setAlbumPerteneciente(Integer albumperteneciente){
        this.AlbumPerteneciente = albumperteneciente;
    }

    public Integer getAlbumPerteneciente(){
        return this.AlbumPerteneciente;
    }

    
    
    public void setPuntuacionPromedio(Integer puntuacionPromedio){
        this.PuntuacionPromedio = puntuacionPromedio;
    }

    public Integer getPuntuacionPromedio(){
        return this.PuntuacionPromedio;
    }

    
    
    
    public void setFecha(Date fecha){
        this.Fecha = fecha;
    }

    public Date getFecha(){
        return this.Fecha;
    }
    
    
    public void setLetra(String letra){
        this.Letra = letra;
    }

    public String getLetra(){
        return this.Letra;
    }


    
    public void setActivo(Boolean activo){
        this.Activo = activo;
    }

    public Boolean getActivo(){
        return this.Activo;
    }
    
    
    

}

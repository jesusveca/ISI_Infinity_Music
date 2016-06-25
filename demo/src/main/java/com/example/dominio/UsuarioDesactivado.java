package com.example.dominio;

import javax.persistence.Entity;

@Entity
// adminstrador es una herencia de user, segun mi diagrama de clases
public class UsuarioDesactivado extends Usuario {
	public UsuarioDesactivado(){};
}


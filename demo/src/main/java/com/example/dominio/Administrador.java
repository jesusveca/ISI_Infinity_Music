package com.example.dominio;

import javax.persistence.Entity;

@Entity
// adminstrador es una herencia de user, segun mi diagrama de clases
public class Administrador extends Usuario {
	public Administrador(){};
}


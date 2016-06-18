package com.example.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Matricula {
	@Id
	@SequenceGenerator(name = "Matricula_ID_GENERATOR", sequenceName = "Matricula_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Matricula_ID_GENERATOR")
	public Integer id;
	public Integer alumno_codigo;
	public Integer curso_codigo;
	public Matricula(){ }
	public Matricula(Integer alumno_codigo, Integer curso_codigo) {
		this.alumno_codigo = alumno_codigo;
		this.curso_codigo = curso_codigo;
	}
}

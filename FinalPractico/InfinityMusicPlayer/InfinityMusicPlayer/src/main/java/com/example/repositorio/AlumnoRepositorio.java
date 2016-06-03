package com.example.repositorio;

import java.util.Arrays;
import java.util.List;

import com.example.dominio.Alumno;

public class AlumnoRepositorio {
	Alumno[] data = {
		new Alumno("Juan", "Perez", 16),
		new Alumno("Maria", "Castro", 14),
		new Alumno("Jose", "Ruiz", 18),
	};
	
	public List<Alumno> listar() {
		return Arrays.asList(data);
	}
}

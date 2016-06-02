package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dominio.Alumno;
import com.example.repositorio.AlumnoRepositorio;

@EnableAutoConfiguration
@Controller
public class DemoApplication {
	AlumnoRepositorio repositorio = new AlumnoRepositorio();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/alumnos")
	@ResponseBody
	public List<Alumno> alumnos(String ordenarPor) {
		return repositorio.listar();
	}
}

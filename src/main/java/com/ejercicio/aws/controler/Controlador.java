package com.ejercicio.aws.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.aws.interfaceService.IpersonaService;
import com.ejercicio.aws.modelo.Persona;

@RestController @CrossOrigin
//@RequestMapping 
public class Controlador {
	
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public List<Persona> listar(Model model) {
		List<Persona>personas=service.listar();
		return personas;
		//model.addAttribute("personas",personas);
		//return "index";
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@RequestBody Persona persona) {
		service.save(persona);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/editar/{id}")
	public Optional<Persona> nuevo(@PathVariable int id) {
		Optional<Persona>persona=service.listarId(id);
		return persona;
	}
	
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

package com.mx.apiRestaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.apiRestaurante.entity.Comidas;
import com.mx.apiRestaurante.service.ComidaServImp;

import jakarta.transaction.Transactional;

//vamos a  ralizar nuestra web services para un api rest---que vamos a trabajar con un json-->@RequestMapping
	//-->Aqui se inicaliza el link-->no importa si se llama diferente a la clase
		//-->Pero es importante para visualizar el archivo en este cas POSTMAN
@RestController
@RequestMapping(path="api/ComidaWs")
@CrossOrigin
public class ComidaWs {

	
	
	//inyeccion de dependencia
	@Autowired
	ComidaServImp comidaImplementacion;
	//Se realiza est variable para saber que se va a ocupar metodos de la clase
	
	//Peticion get para listar
	//http://localhost:9000/api/ComidaWs/listar
	@GetMapping("listar")
	public List<Comidas> listar(){
		return comidaImplementacion.listar();
	}
	//Envia la respuesta del servido al cliente ResponseEntity                              
	//http://localhost:9000/api/ComidaWs/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<?> guardar(@RequestBody Comidas comida){
		boolean respuesta=comidaImplementacion.guardar(comida);
		if (respuesta==true) 
			return new ResponseEntity<>("Ese nombre ya existe, se se puede guardar",HttpStatus.OK);
		else
			return new ResponseEntity<>(comida, HttpStatus.CREATED);
		
	}
	//Terminar
	//buscar x id
	//http://localhost:9000/api/ComidaWs/buscarXid
	@PostMapping ("buscarXid")
	public Comidas buscarXid(@RequestBody Comidas comida) {
		return comidaImplementacion.buscarXid(comida.getIdCom());
	}
	
	//http://localhost:9000/api/ComidaWs/editar
	//el editar-->Validar que esista el Id
	@PostMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Comidas comida) {
		boolean respu=comidaImplementacion.editar(comida);
		if (respu==true) 
			return new ResponseEntity<>(comida,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Ese Id no existe en la BD", HttpStatus.OK);		
	}
	
	//Eliminar -->Validar que el Id exista parta eliminar
	
	//Se va acupar entity
	//
}


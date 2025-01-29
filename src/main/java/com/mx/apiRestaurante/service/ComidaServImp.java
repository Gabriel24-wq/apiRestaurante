package com.mx.apiRestaurante.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.apiRestaurante.entity.Comidas;
import com.mx.apiRestaurante.repository.ComidasRepository;


@Service
public class ComidaServImp {

	
		@Autowired
		ComidasRepository repository;
		
		//Se usa para saber que sera de solo lectura
		@Transactional(readOnly=true)
		public List<Comidas> listar() {
		List<Comidas> lista= repository.findAll();
			return lista;
		}
		
		
		//Validaciones-->Validar que el nombre no se repita, caso contrario guardar
		//No se le pone readOnly por que va hacer cambios en la BD
		@Transactional
		public boolean guardar(Comidas comida) {
			//ciclo
			//Bander
			//Condicion	
			boolean bandera= false ;	
			for (Comidas c: repository.findAll()) {
				if(c.getNombre().equals(comida.getNombre())) {
					bandera= true;
					break;
					//Se pone el break para no recorrer tpda la lista
					//y cvuando lo encuentre se detenga
				}
			}
			if(bandera==false)
				repository.save(comida);
			return bandera;
		}
		@Transactional
		public Comidas buscarXid(Long idCom) {
			Comidas comidaEncontrad=repository.findById(idCom).orElse(null);
			return comidaEncontrad;			
			
		}
		
		
		@Transactional
		public boolean editar(Comidas comida) {
			boolean bandera=false;
			for(Comidas c: repository.findAll()) {
				if(c.getIdCom().equals(comida.getIdCom())) {
					repository.save(comida);				
					bandera=true;
					break;
				}	
			}		
			if (bandera==false)
				bandera = false;
			return bandera;
		}
		//Eliminar Registro por id
		@Transactional
		public boolean eliminarXid(Comidas comida) {
			boolean band=false;
			for (Comidas c: repository.findAll()) {
				if (c.getIdCom().equals(comida.getIdCom())) {
					repository.deleteById(comida.getIdCom());
					band=true;
					break;
				}				
			}		
			if(band==false)
				band=false;
			return band ;
			
		}
		@Transactional
		//Se pone string por que recibra una cadena del POSTMAN
		public boolean eliminarXnombre(String nombre) {
			boolean band=false;			
			//Se recorre toda la coleccion con un for each de ComidasRepository.encuentra todo
			for(Comidas c:repository.findAll()) {
				//Comparamos si existe un nombre com el de la cadena nombre entre a ComidasRepository 
				if(c.getNombre().equals(nombre)) {
					//y borre el elemento
					repository.delete(c);
					band=true;
					break;
				}
					
			}
			return band;
		}
		
		//Buscar pro fecha
		@Transactional(readOnly = true)
		public List<Comidas> buscarXfecha(Comidas comida) {
			List<Comidas> lista=new ArrayList<>();
			for(Comidas c:repository.findAll()) {
				if(c.getFechaVenta().equals(comida.getFechaVenta())) {
					lista.add(c);
				}
			}
			return lista;
		}
}



//.equals-->Comparar valores cadena(String)
//Y cuando comparamos tipos de datos primitvos 
//que estan parceados


//Si queremos comparar tipos de datos primitivos 
//y no esta parseados utilizamos el ==
//


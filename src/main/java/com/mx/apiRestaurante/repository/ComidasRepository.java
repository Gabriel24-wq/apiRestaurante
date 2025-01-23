package com.mx.apiRestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.apiRestaurante.entity.Comidas;

//Como es una interface se usa "Extends"
public interface ComidasRepository extends JpaRepository<Comidas, Long> {

	
}

package com.mx.apiRestaurante.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
 CREATE TABLE COMIDAS_MEX(
ID NUMBER PRIMARY KEY,
NOMBRE NVARCHAR2(100) NOT NULL,
PRECIO NUMBER NOT NULL,
DESCRIPCION NVARCHAR2(80) NOT NULL,
FECHA_VENTA DATE
);
 */
//AQUI SE REALIZA EL MAPEO

//SEREALIZAR SIRVE PARA DOS COAS
	//1->SERIALIZAR-->DESINTEGRACION DE BUTES DEL ESTADO DE UN OBJETO
	//2->DESEAREALIZACION-->RECONSTRUCCION DEL ESTADO DEL OBJETO APARTIR DE LOS BYTES
//@Table(name="COMIDAS_MEX")-->SE DEBE PONER EL NOMBRE DE LA TABLA DE SQL
@Entity
@Table(name="COMIDAS_MEX")
@Data
public class Comidas implements Serializable{

	//Es para que sea compatible con varias versiones java
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//CUANDO NUESTRA LLAVE PRIMARIA ES AURTO INCREMENTABLE
	@Column (name="ID")
	private Long idCom;
	//Si no se parcea un valor en este caso long a Long para que acepte valores null
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="PRECIO")
	private Float precio;
	
	@Column (name = "DESCRIPCION")
	private String descripcion;
	
	@Column (name="FECHA_VENTA")
	private Date fechaVenta;
	
	
	

}
//EN NORMALIZAR LA BD ES QUE TODAS LAS TABLAS DEBEN TENER UN ID
//CUANDO EL ID ES AUTOINCREMENTABLE NO SE PIDE PARA NO GUARDARLO CON EL -->@GENERATEVALUE=(GENERACION)
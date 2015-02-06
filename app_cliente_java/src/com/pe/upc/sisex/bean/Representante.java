package com.pe.upc.sisex.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Representante implements Serializable{

	private String documento;
	private String numero;
	private String nombre;
	private String cargo;
	private String fechadesde;
	
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getFechadesde() {
		return fechadesde;
	}
	public void setFechadesde(String fechadesde) {
		this.fechadesde = fechadesde;
	}
	
}

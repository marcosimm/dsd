package com.pe.upc.sisex.bean;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class DatosSunat implements Serializable{

	private String _id;
	private String ruc;
	private String razonsocial;
	private String fechains;
	private String condicion;
	private String estado;
	private String direccion;
	private String telefono1;
	private String anexo1;
	private String tipo;
	private ArrayList<Representante> represetantes;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getFechains() {
		return fechains;
	}
	public void setFechains(String fechains) {
		this.fechains = fechains;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getAnexo1() {
		return anexo1;
	}
	public void setAnexo1(String anexo1) {
		this.anexo1 = anexo1;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ArrayList<Representante> getRepresetantes() {
		return represetantes;
	}
	public void setRepresetantes(ArrayList<Representante> represetantes) {
		this.represetantes = represetantes;
	}
	
}

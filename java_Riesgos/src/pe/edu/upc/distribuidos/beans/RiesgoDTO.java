package pe.edu.upc.distribuidos.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RiesgoDTO implements Serializable{

	private int id;
	private double score;
	private double montoTotal;
	private int variacion;
	private String actual;
	private String semestre;
	private String anual;
	private String ruc;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public int getVariacion() {
		return variacion;
	}
	public void setVariacion(int variacion) {
		this.variacion = variacion;
	}
	public String getActual() {
		return actual;
	}
	public void setActual(String actual) {
		this.actual = actual;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getAnual() {
		return anual;
	}
	public void setAnual(String anual) {
		this.anual = anual;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
}

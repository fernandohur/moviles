package com.fer.pasajero.model;

public class Ubicacion {

	private String calle;
	private String carrera;
	private String apartamento;
	private String extraInfo;
	
	public Ubicacion(String calle, String carrera, String apartamento,
			String extraInfo) {
		super();
		this.calle = calle;
		this.carrera = carrera;
		this.apartamento = apartamento;
		this.extraInfo = extraInfo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	
	
	
	
}

package com.ft.clientetaxi.model;

import java.util.Date;

public class Solicitud {

	private String numero;
	private String ubicacion;
	private boolean confirmado;
	private Date fecha;
	
	public Solicitud(String numero, String ubicacion, boolean confirmado) {
		super();
		this.numero = numero;
		this.ubicacion = ubicacion;
		this.confirmado = confirmado;
		fecha = new Date();
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	
	public boolean isConfirmado() {
		return confirmado;
	}
	
	public void setConfirmado(boolean b)
	{
		confirmado = b;
	}
	
	public Date getDate()
	{
		return fecha;
	}

}

package com.fer.pasajero.model;

import java.util.ArrayList;
import java.util.List;


import android.app.Application;

public class PasajeroApp extends Application {

	private List<Ubicacion> ubicacionesFrecuentes;
	
	public PasajeroApp() {
		ubicacionesFrecuentes = new ArrayList<Ubicacion>();
	}

	public List<Ubicacion> getUbicacionesFrecuentes() {
		return ubicacionesFrecuentes;
	}
	
	
	
}

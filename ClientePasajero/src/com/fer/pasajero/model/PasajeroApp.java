package com.fer.pasajero.model;

import java.util.ArrayList;
import java.util.List;


import android.app.Application;

public class PasajeroApp extends Application {

	private List<Ubicacion> ubicacionesFrecuentes;
	
	public PasajeroApp() {
		ubicacionesFrecuentes = new ArrayList<Ubicacion>();
		ubicacionesFrecuentes.add(
				new Ubicacion("132", "12-45", "420", "", "Mi casa"));
	}

	public List<Ubicacion> getUbicacionesFrecuentes() {
		return ubicacionesFrecuentes;
	}
	
	
	
}

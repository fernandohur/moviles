package com.ft.clientetaxi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;

import com.ft.clientetaxi.ConfirmarServicioActivity;
import com.ft.common.AbstractMessenger;
import com.ft.common.SmsSender;
import com.ft.common.protocol.ProtocolManager;
import com.ft.common.protocol.SMSC;

public class TaxiMessenger extends AbstractMessenger{

	public final static String EXTRA_NUMERO = "numero";
	public final static String EXTRA_UBICACION = "dir";
	public final static String EXTRA_CONF = "conf";
	
	public static TaxiMessenger instance; 
	
	private HashMap<String,Solicitud> solicitudes;
	
	private TaxiMessenger() {
		super(new SmsSender());
		solicitudes = new HashMap<String,Solicitud>();
	}
	
	public static TaxiMessenger getInstance(){
		if(instance == null){
			instance = new TaxiMessenger();
		}
		return instance;
	}

	@Override
	public void onMessageReceived(String sender, String message, Context context) {
		
		if (ProtocolManager.isSolicitarServicioTaxista(message) && sender.equals(SMSC.SMSC_NUMBER))
		{
			String numero = ProtocolManager.extractNumeroSolicitarServicioTaxista(message);
			String dir = ProtocolManager.extractUbicacionSolicitarServicioTaxista(message);
			
			solicitudes.put(numero,new Solicitud(numero, dir, false));
			
			Intent i = new Intent(context, ConfirmarServicioActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			i.putExtra(EXTRA_NUMERO, numero);
			i.putExtra(EXTRA_UBICACION, dir);
			i.putExtra(EXTRA_CONF, false);
			context.startActivity(i);
		}
		
	}
	
	public void enviarConfirmacion(int tiempoAprox, String idPasajero)
	{
		solicitudes.get(idPasajero).setConfirmado(true);
		sender.sendMessage(idPasajero, ProtocolManager.getServicioConfirmado(tiempoAprox));
	}
	
	public ArrayList<Solicitud> getSolicitudes(){
		ArrayList<Solicitud> ubs = new ArrayList<Solicitud>(solicitudes.size());
		for (Solicitud sol : solicitudes.values()) {
			ubs.add(sol);
		}
		return ubs;
	}
	
	public void eliminarSolicitud(String numero){
		solicitudes.remove(numero);
	}

	
}

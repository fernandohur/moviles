package com.fer.pasajero.model;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fer.pasajero.activities.ServicioConfirmadoActivity;

public class PasajeroManager extends AbstractPasajeroMessenger {

	private static PasajeroManager instance;
	
	private PasajeroManager() {
		super(new com.ft.common.SmsSender());
	}
	
	public void solicitarTaxi(Ubicacion ubicacion)
	{
		String ubicacionString = 
				"Calle " + ubicacion.getCalle() +
				" Cra "+ubicacion.getCarrera() +
				", Apt " + ubicacion.getApartamento()+
				" " +ubicacion.getExtraInfo();
				
		solicitarTaxi(ubicacionString);
	}

	@Override
	public void onServicioConfirmado(String message, Context context) {
		Log.d("SMS_Received", sender+": "+message); 
		Intent i = new Intent(context, ServicioConfirmadoActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
	}

	@Override
	public void onUnknownMessage(String sender, String message, Context context) {
		Log.d("SMS_Received", sender+": "+message);
	}

	public static PasajeroManager get()
	{
		if (instance == null)
		{
			instance = new PasajeroManager();
		}
		return instance;
	}
}

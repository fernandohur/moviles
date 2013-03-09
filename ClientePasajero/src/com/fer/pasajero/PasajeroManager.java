package com.fer.pasajero;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.fer.pasajero.activities.ServicioConfirmadoActivity;
import com.fer.smsc.messageProtocol.sender.PasajeroSender;
import com.fer.smsc.messageProtocol.sender.SmsSender;

public class PasajeroManager extends PasajeroSender {

	private static PasajeroManager instance;
	
	private PasajeroManager() {
		super(new SmsSender());
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
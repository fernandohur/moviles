package com.fer.pasajero.model;

import android.content.Context;

import com.ft.common.AbstractMessenger;
import com.ft.common.MessageSender;
import com.ft.common.protocol.ProtocolManager;
import com.ft.common.protocol.SMSC;

public abstract class AbstractPasajeroMessenger extends AbstractMessenger{

	
	public AbstractPasajeroMessenger(MessageSender sender) {
		super(sender);
	}
	
	protected void solicitarTaxi(String ubicacion)
	{
		String message = ProtocolManager.getSolicitarServicio(ubicacion);
		sender.sendMessage(SMSC.SMSC_NUMBER, message);
	}
	
	@Override
	public void onMessageReceived(String sender, String message, Context context) {
		if (sender.equals(SMSC.SMSC_NUMBER))
		{
			if(ProtocolManager.isServicioConfirmado(message))
			{
				onServicioConfirmado(message, context);
			}
			else
			{
				onUnknownMessage(sender, message, context);
			}
		}
	}
	
	public abstract void onServicioConfirmado(String message, Context c);
	public abstract void onUnknownMessage(String sender, String message,Context c);
}

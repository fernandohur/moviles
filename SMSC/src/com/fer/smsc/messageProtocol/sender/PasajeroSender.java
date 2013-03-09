package com.fer.smsc.messageProtocol.sender;

import android.content.Context;

import com.ft.common.AbstractSender;
import com.ft.common.MessageSender;
import com.ft.common.protocol.ProtocolManager;
import com.ft.common.protocol.SMSC;

public abstract class PasajeroSender extends AbstractSender{

	
	public PasajeroSender(MessageSender sender) {
		super(sender);
	}
	
	public void solicitarTaxi(String ubicacion)
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
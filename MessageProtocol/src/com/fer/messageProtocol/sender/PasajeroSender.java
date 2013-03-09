package com.fer.messageProtocol.sender;

import com.fer.messageProtocol.SMSC;
import com.fer.messageProtocol.ProtocolManager;

public abstract class PasajeroSender implements MessageReceiver{

	private MessageSender sender;
	
	public PasajeroSender(MessageSender sender) {
		this.sender = sender;
	}
	
	public void solicitarTaxi(String ubicacion)
	{
		String message = ProtocolManager.getSolicitarServicio(ubicacion);
		sender.sendMessage(SMSC.SMSC_NUMBER, message);
	}
	
	@Override
	public void onMessageReceived(String sender, String message) {
		if (sender.equals(SMSC.SMSC_NUMBER))
		{
			if(ProtocolManager.isServicioConfirmado(message))
			{
				onServicioConfirmado(message);
			}
			else
			{
				onUnknownMessage(sender, message);
			}
		}
	}
	
	public abstract void onServicioConfirmado(String message);
	public abstract void onUnknownMessage(String sender, String message);
}
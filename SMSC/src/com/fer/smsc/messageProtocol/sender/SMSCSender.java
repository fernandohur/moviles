package com.fer.smsc.messageProtocol.sender;

import java.util.List;

import android.content.Context;

import com.ft.common.AbstractSender;
import com.ft.common.Confirmacion;
import com.ft.common.MessageSender;
import com.ft.common.protocol.ProtocolManager;

public class SMSCSender extends AbstractSender{
	
	private List<String> taxisList;
	
	public SMSCSender(MessageSender sender, List<String> taxiList) {
		super(sender);
		this.taxisList = taxiList;
	}
	
	public void sendConfirmar(String ubicacion)
	{
		for (String taxiId : taxisList) {
			String message = ProtocolManager.getSolicitarServicio(ubicacion);
			sender.sendMessage(taxiId, message);
		}
	}
	
	
	@Override
	public void onMessageReceived(String sender, String message, Context c) {
		
		if (ProtocolManager.isConfirmarServicio(message))
		{
			Confirmacion confirmacion = ProtocolManager.getConfirmarServicio(message);
			onConfirmarServicio(confirmacion);
		}
		else if (ProtocolManager.isSolicitarServicio(message))
		{
			String direccion = ProtocolManager.getDireccion(message);
			sendConfirmar(direccion);
		}
	}

	public void onConfirmarServicio(Confirmacion confirmacion) {
		String pasajeroId = confirmacion.getPasajeroId();
		sender.sendMessage(pasajeroId, ProtocolManager.getServicioConfirmado(confirmacion.getTiempoAprox()));
	}
	
}

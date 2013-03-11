package com.fer.smsc.messageProtocol.sender;

import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.ft.common.AbstractMessenger;
import com.ft.common.SmsSender;
import com.ft.common.protocol.ProtocolManager;

public class SMSCManager extends AbstractMessenger{
	
	private List<String> taxisList;
	private static SMSCManager instance;
	final static String TAG = "SMSC";
	
	public static SMSCManager get()
	{
		if (instance==null)
		{
			instance = new SMSCManager("5554");
		}
		return instance;
	}
	
	public SMSCManager(String... taxiList) {
		super(new SmsSender());
		this.taxisList = Arrays.asList(taxiList);
	}
	
	public void sendConfirmar(String ubicacion, String pasajeroID)
	{
		Log.d(TAG, "Enviando confirmacion");
		for (String taxiId : taxisList) {
			
			String message = ProtocolManager.getSolicitarServicioTaxista(pasajeroID, ubicacion);
			Log.d(TAG, "Enviando confirmacion al taxi "+taxiId+" con "+message);
			sender.sendMessage(taxiId, message);
		}
	}
	
	
	@Override
	public void onMessageReceived(String sender, String message, Context c) {
		Log.d(TAG, "SMS Received from " + sender + " with message "+message);
		if (ProtocolManager.isSolicitarServicio(message))
		{
			String direccion = ProtocolManager.extractDireccion(message);
			
			sendConfirmar(direccion,sender);
		}
	}

	
}

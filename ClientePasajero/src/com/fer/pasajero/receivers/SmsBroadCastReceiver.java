package com.fer.pasajero.receivers;

import com.fer.pasajero.PasajeroManager;
import com.fer.smsc.broadcast.SmsReceiver;

public class SmsBroadCastReceiver extends SmsReceiver {

	
	public SmsBroadCastReceiver() {
		setMessageReceiver(PasajeroManager.get());
	}
}

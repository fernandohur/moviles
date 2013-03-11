package com.fer.pasajero.receivers;

import com.fer.pasajero.model.PasajeroManager;
import com.ft.common.SmsReceiver;

public class SmsBroadCastReceiver extends SmsReceiver {

	
	public SmsBroadCastReceiver() {
		super(PasajeroManager.get());
	}
}

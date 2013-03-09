package com.ft.clientetaxi;

import com.ft.clientetaxi.model.TaxiMessenger;


public class SmsReceiver extends com.ft.common.SmsReceiver{

	public SmsReceiver() {
		super(TaxiMessenger.getInstance());
	}
}

package com.fer.smsc.broadcast;

import com.fer.smsc.messageProtocol.sender.SMSCManager;


public class SmsReceiver extends com.ft.common.SmsReceiver {

	public SmsReceiver() {
		super(SMSCManager.get());
	}
}

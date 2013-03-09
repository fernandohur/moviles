package com.ft.common;

import android.telephony.SmsManager;

public class SmsSender implements MessageSender{

	@Override
	public void sendMessage(String receiver, String message) {
		SmsManager.getDefault().sendTextMessage(receiver, null, message, null, null);
	}
}

package com.ft.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver{

	private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
	private static final String TAG = "smsfwd";


	private MessageReceiver receiver;
	
	public SmsReceiver(MessageReceiver receiver) {
		this.receiver = receiver;
	}
	
	
	@Override
	/**
	 * Utiliza el MessageReceiver para enviarle el numero y el mensaje del SMS que lleg�
	 */
	public void onReceive(Context context, Intent intent) {

		if (intent.getAction().equals(SMS_RECEIVED)) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				Object[] pdus = (Object[])bundle.get("pdus");
				final SmsMessage[] messages = new SmsMessage[pdus.length];
				for (int i = 0; i < pdus.length; i++) {
					messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
				}
				if (messages.length > -1) {
					Log.i(TAG, "Message recieved: " + messages[0].getMessageBody()+" from: "+messages[0].getOriginatingAddress());
					String messageBody = messages[0].getMessageBody();
					String sender = messages[0].getOriginatingAddress();
					if (receiver!=null)
					{
						receiver.onMessageReceived(sender, messageBody, context);
					}
					else
					{
						Log.d(TAG, "MessageReceiver is null");
					}
				}
			}
		}
	}
	
	public void setMessageReceiver(MessageReceiver receiver)
	{
		this.receiver = receiver;
	}

}



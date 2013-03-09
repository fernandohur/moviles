package com.ft.common;

import android.content.Context;

public interface MessageReceiver {

	public void onMessageReceived(String sender, String message, Context context);
	
}

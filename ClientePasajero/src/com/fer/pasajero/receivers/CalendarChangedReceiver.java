package com.fer.pasajero.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CalendarChangedReceiver extends BroadcastReceiver {

	final static String TAG = "Calendar Event";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "Calendar event");
		Log.d(TAG,""+intent);
		if (intent!=null)
		{
			
			
		}

	}



}

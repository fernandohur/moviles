package com.fer.pasajero.activities.widgets;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Dialog {

	public final static void show(String title, String message, Context context, DialogInterface.OnClickListener clickListener)
	{
		new AlertDialog.Builder(context)
		.setTitle(title)
		.setMessage(message)
		.setIcon(android.R.drawable.ic_dialog_alert)
		.setPositiveButton(android.R.string.yes, clickListener)
		 .setNegativeButton(android.R.string.no, null).show();
	}
	
}

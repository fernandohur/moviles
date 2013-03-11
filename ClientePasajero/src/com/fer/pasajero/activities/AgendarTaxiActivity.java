package com.fer.pasajero.activities;

import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.fer.pasajero.R;
import com.fer.pasajero.services.SolicitarTaxiService;

public class AgendarTaxiActivity extends Activity implements OnClickListener {

	DatePicker datePicker;
	TimePicker timePicker;
	EditText txtUbicacion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agendar_taxi);
		
		txtUbicacion= (EditText)findViewById(R.id.txtUbicacion);
		datePicker = (DatePicker)findViewById(R.id.datePicker);
		timePicker = (TimePicker)findViewById(R.id.timePicker);
		findViewById(R.id.btnAgendarTaxi).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		
		int date = datePicker.getDayOfMonth();
		int month = datePicker.getMonth();
		int year = datePicker.getYear();
		
		
		int hour = timePicker.getCurrentHour();
		int minutes = timePicker.getCurrentMinute();
		
		
		Intent intent = new Intent(Intent.ACTION_INSERT);
		intent.setType("vnd.android.cursor.item/event");
		intent.putExtra(Events.TITLE, "Pedir un Taxi");
		intent.putExtra(Events.EVENT_LOCATION, txtUbicacion.getText());
		intent.putExtra(Events.EVENT_LOCATION, txtUbicacion.getText());

		// Setting dates
		GregorianCalendar calDate = new GregorianCalendar(year,month,date,hour,minutes);
		intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
		  calDate.getTimeInMillis());
		intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
		  calDate.getTimeInMillis());
		startActivity(intent);
		
		startAlarm(calDate);
		finish();

	}

	private void startAlarm(GregorianCalendar calDate) {
		
		Intent intent = new Intent(this, SolicitarTaxiService.class);
		PendingIntent pendingIntent =  PendingIntent.getService(this, 0, intent, 0);
		
		AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, calDate.getTimeInMillis(), pendingIntent);
	}

	
	

}

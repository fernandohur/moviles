package com.fer.pasajero.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.fer.pasajero.R;

public class EsperarTaxiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_esperar_taxi);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_esperar_taxi, menu);
		return true;
	}

}

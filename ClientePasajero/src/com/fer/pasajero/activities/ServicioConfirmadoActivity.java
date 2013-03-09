package com.fer.pasajero.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.fer.pasajero.R;

public class ServicioConfirmadoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_servicio_confirmado);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_servicio_confirmado, menu);
		return true;
	}

}

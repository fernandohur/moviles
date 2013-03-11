package com.fer.pasajero.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.fer.pasajero.R;

public class EsperarTaxiActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_esperar_taxi);
		
		findViewById(R.id.btnVolver).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		finish();
	}

}

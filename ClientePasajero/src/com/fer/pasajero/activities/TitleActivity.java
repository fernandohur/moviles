package com.fer.pasajero.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.fer.pasajero.R;

public class TitleActivity extends FragmentActivity implements OnClickListener {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);
		setTitle("CabScore");
		
		findViewById(R.id.btnSolicitarTaxi).setOnClickListener(this);
		findViewById(R.id.btnCrearUbicacion).setOnClickListener(this);
		findViewById(R.id.btnUbicaciones).setOnClickListener(this);
		
	}

	
	@Override
	public void onClick(View v) {
		
		if (v.equals(findViewById(R.id.btnSolicitarTaxi)))
		{
			Intent intent = new Intent(this,SolicitarTaxiActivity.class);
			startActivity(intent);
		}
		else if (v.equals(findViewById(R.id.btnCrearUbicacion)))
		{
			Intent intent = new Intent(this,CrearUbicacionActivity.class);
			startActivity(intent);
		}
		else if (v.equals(findViewById(R.id.btnUbicaciones)))
		{
			Intent intent = new Intent(this, UbicacionesActivity.class);
			startActivity(intent);
		}
	}

	

}

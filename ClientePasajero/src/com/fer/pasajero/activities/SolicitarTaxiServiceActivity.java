package com.fer.pasajero.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fer.pasajero.R;
import com.fer.pasajero.activities.widgets.Dialog;
import com.fer.pasajero.model.PasajeroManager;
import com.fer.pasajero.model.Ubicacion;

public class SolicitarTaxiServiceActivity extends Activity implements android.view.View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solicitar_taxi);
		
		findViewById(R.id.btnPedirTaxi).setOnClickListener(this);
		findViewById(R.id.btnGoToUbicaciones).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		
		if (v.equals(findViewById(R.id.btnPedirTaxi)))
		{
			pedirTaxi();
		}
		else if (v.equals(findViewById(R.id.btnGoToUbicaciones)))
		{
			Intent i = new Intent(this, UbicacionesActivity.class);
			startActivity(i);
		}
		
	}

	private void pedirTaxi() {
		TextView txtCalle =  (TextView) findViewById(R.id.txtCalle);
		TextView txtCarrera = (TextView) findViewById(R.id.txtCarrera);
		TextView txtApt = (TextView) findViewById(R.id.txtApt);
		final Ubicacion ubicacion = new Ubicacion(txtCalle.getText().toString(),
				txtCarrera.getText().toString(), txtApt.getText().toString(), "", "");
		
		Dialog.show("Solicitar Taxi", "Estas seguro que quieres pedir un taxi a la direccion "+ubicacion+" ?", this, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				PasajeroManager.get().solicitarTaxi(ubicacion);
				Toast.makeText(getApplicationContext(), "Solicitud enviada", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(SolicitarTaxiServiceActivity.this, EsperarTaxiActivity.class);
				startActivity(intent);
				
			}
		});
		
	}


}

package com.fer.pasajero.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.fer.pasajero.R;
import com.fer.pasajero.model.PasajeroManager;
import com.fer.pasajero.model.Ubicacion;

public class SolicitarTaxiActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_solicitar_taxi);
		
		findViewById(R.id.btnPedirTaxi).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(this, EsperarTaxiActivity.class);
		startActivity(intent);
		
		
		pedirTaxi();
	}

	private void pedirTaxi() {
		TextView txtCalle =  (TextView) findViewById(R.id.txtCalle);
		TextView txtCarrera = (TextView) findViewById(R.id.txtCarrera);
		TextView txtApt = (TextView) findViewById(R.id.txtApt);
		Ubicacion ubicacion = new Ubicacion(txtCalle.getText().toString(),
				txtCarrera.getText().toString(), txtApt.getText().toString(), "");
		PasajeroManager pm = PasajeroManager.get();
		pm.solicitarTaxi(ubicacion);
	}


}

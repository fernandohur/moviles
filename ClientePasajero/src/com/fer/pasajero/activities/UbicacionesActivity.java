package com.fer.pasajero.activities;

import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.fer.pasajero.R;
import com.fer.pasajero.activities.widgets.Dialog;
import com.fer.pasajero.activities.widgets.UbicacionesAdapter;
import com.fer.pasajero.model.PasajeroApp;
import com.fer.pasajero.model.PasajeroManager;
import com.fer.pasajero.model.Ubicacion;

public class UbicacionesActivity extends Activity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ubicaciones);


		ListView listView = (ListView) findViewById(R.id.mylist);
		listView.setClickable(true);		
		BaseAdapter adapter = new UbicacionesAdapter(getValues());
		listView.setOnItemClickListener(this);
		listView.setAdapter(adapter); 

	}

	private List<Ubicacion> getValues()
	{
		PasajeroApp app = (PasajeroApp)getApplication();
		List<Ubicacion> ubicaciones = app.getUbicacionesFrecuentes();
		return ubicaciones;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int arg2, long arg3) {
		UbicacionesAdapter adapt = (UbicacionesAdapter)adapter.getAdapter();
		final Ubicacion ubicacion = (Ubicacion) adapt.getItem(arg2);
		Dialog.show("Solicitar taxi", "deseas pedir un taxi a la direccion "+ubicacion, this, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				try {
					PasajeroManager.get().solicitarTaxi(ubicacion);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Intent i = new Intent(UbicacionesActivity.this, EsperarTaxiActivity.class);
				UbicacionesActivity.this.startActivity(i);
			}
		});
	}

}

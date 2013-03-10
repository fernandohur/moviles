package com.fer.pasajero.activities;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.fer.pasajero.R;
import com.fer.pasajero.activities.widgets.UbicacionesAdapter;
import com.fer.pasajero.model.PasajeroApp;
import com.fer.pasajero.model.Ubicacion;

public class UbicacionesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ubicaciones);


		ListView listView = (ListView) findViewById(R.id.mylist);
				
		BaseAdapter adapter = new UbicacionesAdapter(getValues());
		
		listView.setAdapter(adapter); 

	}

	private List<Ubicacion> getValues()
	{
		PasajeroApp app = (PasajeroApp)getApplication();
		List<Ubicacion> ubicaciones = app.getUbicacionesFrecuentes();
		return ubicaciones;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ubicaciones, menu);
		return true;
	}

}

package com.fer.pasajero.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.fer.pasajero.R;
import com.fer.pasajero.activities.widgets.Dialog;
import com.fer.pasajero.model.PasajeroApp;
import com.fer.pasajero.model.Ubicacion;

public class CrearUbicacionActivity extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crear_ubicacion);
		findViewById(R.id.btnGuardarUbicacion).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_crear_ubicacion, menu);
		return true;
	}

	@Override
	public void onClick(View v) {

		TextView txtCalle = (TextView)findViewById(R.id.txtCalle);
		TextView txtCarrera = (TextView)findViewById(R.id.txtCarrera);
		TextView txtApt = (TextView)findViewById(R.id.txtApt);
		TextView txtNum = (TextView)findViewById(R.id.txtNumero);
		TextView txtNombre = (TextView)findViewById(R.id.txtNombre);

		String calle = txtCalle.getText().toString();
		String carrera =txtCarrera.getText().toString();
		String apt = txtApt.getText().toString();
		String numero = txtNum.getText().toString();
		String nombre = txtNombre.getText().toString();

		final Ubicacion ubicacion = new Ubicacion(calle, carrera+" - "+numero, apt, "", nombre);

		Dialog.show("Ubicacion Frecuente", "Estas seguro que la direccion "+ubicacion+" es correcta.", this,
				new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int whichButton){
				crearUbicacion(ubicacion);
				Toast.makeText(CrearUbicacionActivity.this, "Ubicacion creada", Toast.LENGTH_SHORT).show();
				CrearUbicacionActivity.this.finish();
			}	
		}
				);
	}

	private void crearUbicacion(Ubicacion ubicacion)
	{
		PasajeroApp app = (PasajeroApp)getApplication();
		app.getUbicacionesFrecuentes().add(ubicacion);
	}

}

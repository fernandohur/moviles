package com.ft.clientetaxi;

import com.ft.clientetaxi.model.TaxiMessenger;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmarServicioActivity extends Activity implements OnClickListener {
	
	private String numPasajero;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirmar_servicio);
		
		numPasajero = getIntent().getStringExtra(TaxiMessenger.EXTRA_NUMERO);
		String ubicacion = getIntent().getStringExtra(TaxiMessenger.EXTRA_UBICACION);
		boolean conf = getIntent().getBooleanExtra(TaxiMessenger.EXTRA_CONF, false);
		
		if(conf){
			findViewById(R.id.btnConf5).setVisibility(View.INVISIBLE);
			findViewById(R.id.btnConf10).setVisibility(View.INVISIBLE);
			findViewById(R.id.btnConf15).setVisibility(View.INVISIBLE);
		} else {
			findViewById(R.id.btnConf5).setOnClickListener(this);
			findViewById(R.id.btnConf10).setOnClickListener(this);
			findViewById(R.id.btnConf15).setOnClickListener(this);			
		}
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		
		TextView txtCon = (TextView)findViewById(R.id.txtMessageConf);
		txtCon.setText("Solicitud de servicio en: "+ubicacion);
	}

	@Override
	public void onClick(View v) {
	
		if(v.equals(findViewById(R.id.btnConf5)))
		{
			sendConfirmation(5);
			
		}
		else if (v.equals(findViewById(R.id.btnConf10)))
		{
			sendConfirmation(10);
		}
		else if (v.equals(findViewById(R.id.btnConf15)))
		{
			sendConfirmation(15);
		}
		showToast();
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem menuItem)
    {   
        startActivity(new Intent(ConfirmarServicioActivity.this,MainActivity.class)); 
        return true;
    }
	
	private void sendConfirmation(int time)
	{
		TaxiMessenger tm = TaxiMessenger.getInstance();
		tm.enviarConfirmacion(time, numPasajero);
	}
	
	private void showToast(){
		Toast.makeText(getApplicationContext(), "El servicio ha sido confirmado", Toast.LENGTH_LONG).show();
	}

}

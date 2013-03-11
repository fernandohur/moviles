package com.ft.clientetaxi;

import com.ft.clientetaxi.model.TaxiMessenger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TaxiMessenger tm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tm = TaxiMessenger.getInstance();

		ListView listView = (ListView) findViewById(R.id.listViewSolicitudes);
		listView.setAdapter(new CustomAdapter(tm.getSolicitudes()));
//		String[] vals = tm.getSolicitudes();
//		String[] vals = {"hey", "ho"};
//
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, vals);
//		listView.setAdapter(adapter);
		
//		listView.setOnItemClickListener(new OnItemClickListener(){
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Toast.makeText(getApplicationContext(), "Click ListItem Number " + position, Toast.LENGTH_LONG).show();
//			}
//		}); 
	}


}

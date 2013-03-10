package com.fer.pasajero.activities.widgets;

import java.util.List;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fer.pasajero.R;
import com.fer.pasajero.model.Ubicacion;

public class UbicacionesAdapter extends BaseAdapter {

	private List<Ubicacion> ubicaciones;

	public UbicacionesAdapter(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	
	@Override
	public int getCount() {
		return ubicaciones.size();
	}

	@Override
	public Object getItem(int position) {
		return ubicaciones.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		if (view == null) {
			
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.list_view_item_ubicaciones, parent, false);
			view.setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					
					return false;
				}
			});
		}
		
		String title = ubicaciones.get(position).getNombre();
		String subtitle = ubicaciones.get(position).toString();
		
		TextView txtTitle = (TextView)view.findViewById(R.id.txtTitle);
		TextView txtSubTitle = (TextView)view.findViewById(R.id.txtSubtitle);
		txtTitle.setText(title);
		txtSubTitle.setText(subtitle);
		
		return view;

	}

}

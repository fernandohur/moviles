package com.ft.clientetaxi;

import android.R.color;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.ft.clientetaxi.model.Solicitud;
import com.ft.clientetaxi.model.TaxiMessenger;

public class CustomAdapter extends BaseAdapter {

    ArrayList<Solicitud> listArray;
    private TaxiMessenger tm;

    public CustomAdapter(ArrayList<Solicitud> al) {
    	tm = TaxiMessenger.getInstance();
        listArray = al;
    }

    @Override
    public int getCount() {
        return listArray.size();    // total number of elements in the list
    }

    @Override
    public Object getItem(int i) {
        return listArray.get(i);    // single item in the list
    }

    @Override
    public long getItemId(int i) {
        return i;                   // index number
    }

    @Override
    public View getView(int index, View view, final ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.single_list_item, parent, false);
        }

        final Solicitud dataModel = listArray.get(index);

        ImageButton button = (ImageButton) view.findViewById(R.id.btnPerrasSucias);
        TextView textView = (TextView) view.findViewById(R.id.tv_string_data);
        if(dataModel.isConfirmado())
        	textView.setBackgroundColor(color.holo_blue_light);
        textView.setText(dataModel.getUbicacion());

//      button.setText("" + dataModel.getAnInt());


        // button click listener
        // this chunk of code will run, if user click the button
        // because, we set the click listener on the button only

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	tm.eliminarSolicitud(dataModel.getNumero());
            	listArray = tm.getSolicitudes();
            	notifyDataSetChanged();
                Toast.makeText(parent.getContext(), "Solicitud Eliminada", Toast.LENGTH_SHORT).show();
            }
        });


        // if you commented out the above chunk of code and
        // activate this chunk of code
        // then if user click on any view inside the list view (except button)
        // this chunk of code will execute
        // because we set the click listener on the whole view


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	Intent i = new Intent(parent.getContext(), ConfirmarServicioActivity.class);
    			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    			i.putExtra(TaxiMessenger.EXTRA_NUMERO, dataModel.getNumero());
    			i.putExtra(TaxiMessenger.EXTRA_UBICACION, dataModel.getUbicacion());
    			i.putExtra(TaxiMessenger.EXTRA_CONF, dataModel.isConfirmado());
    			parent.getContext().startActivity(i);
//                Toast.makeText(parent.getContext(), "view clicked: ", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}

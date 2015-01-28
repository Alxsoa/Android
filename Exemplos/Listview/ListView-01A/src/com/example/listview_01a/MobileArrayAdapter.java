package com.example.listview_01a;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MobileArrayAdapter extends ArrayAdapter<String> 
{
	private final Context context;
	private final String[] values;

	public MobileArrayAdapter(Context context, String[] values) 
	{
		super(context, R.layout.activity_main, values);
		this.context = context;
		this.values = values;
		Log.v ("MeuLog", "Ativei o MobileArray");
	}

	@Override
	public View getView(int iPosicao, View convertView, ViewGroup parent) 
	{
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vLinha = inflater.inflate(R.layout.activity_main, parent, false);
		
		TextView textView 	= (TextView) vLinha.findViewById(R.id.label);
		
		if ( (iPosicao % 2) == 0)
		{
			textView.setTextColor(Color.parseColor("#FFD700"));
		}
		else
		{
			textView.setTextColor(Color.parseColor("#DAA520"));			
		}
		textView.setText(values[iPosicao]);	
		
		Log.v("MeuLog", "Ativei o getView");
		return vLinha;
	}
}

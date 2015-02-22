package com.example.listview_02;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
	}

	@Override
	public View getView(int iPosicao, View convertView, ViewGroup parent) 
	{
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vLinha = inflater.inflate(R.layout.activity_main, parent, false);
		
		TextView textView 	= (TextView) vLinha.findViewById(R.id.label);
		ImageView imageView = (ImageView) vLinha.findViewById(R.id.logo);
		textView.setText(values[iPosicao]);

		String s = values[iPosicao];
		if (s.equals("Windows Mobile")) 
		{
			imageView.setImageResource(R.drawable.windowsmobile_logo);
		} 
		else 
			if (s.equals("iOS")) 
			{
				imageView.setImageResource(R.drawable.ios_logo);
			} 
			else 
				if (s.equals("Blackberry")) 
				{
					imageView.setImageResource(R.drawable.blackberry_logo);
				} 
				else 
				{
					imageView.setImageResource(R.drawable.android_logo);
				}

		return vLinha;
	}
}

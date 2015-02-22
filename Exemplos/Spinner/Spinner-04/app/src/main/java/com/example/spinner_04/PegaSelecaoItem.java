package com.example.spinner_04;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class PegaSelecaoItem implements OnItemSelectedListener 
{

	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) 
	{
		if ( pos > 0 )
		{
		Toast.makeText(	parent.getContext(), 
						"Cidade Selecionada foi " + parent.getItemAtPosition(pos).toString(),
						Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) 
	{
		
	}
}


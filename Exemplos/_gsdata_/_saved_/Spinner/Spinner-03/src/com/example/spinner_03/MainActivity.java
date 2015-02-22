package com.example.spinner_03;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity 
{

	private Spinner spiLista;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ColocaDadosSpinner();
	}

	public void ColocaDadosSpinner() 
	{

		spiLista = (Spinner) findViewById(R.id.spntimes);
		List<String> listaCidades = new ArrayList<String>();

		listaCidades.add(" ");
		listaCidades.add("Rio de Janeiro");
		listaCidades.add("S‹o Paulo");
		listaCidades.add("Belo Horizonte");
		listaCidades.add("Porto Alegre");
		listaCidades.add("Bras’lia");
		listaCidades.add("Recife");		
				
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_spinner_item,listaCidades);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spiLista.setAdapter(dataAdapter);
	}	
}


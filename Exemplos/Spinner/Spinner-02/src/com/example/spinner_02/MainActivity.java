package com.example.spinner_02;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity 
{
	Spinner spntimes;
	private static final String[] Cidades = { 
											"",
											"Rio de Janeiro", 
											"S‹o Paulo",
											"Belo Horizonte", 
											"Porto Alegre", 
											"Bras’lia", 
											"Recife", 
											"Salvador" 
											};

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spntimes = (Spinner) findViewById(R.id.spntimes);
		ArrayAdapter<String> dataAdapter = 
				new ArrayAdapter<String>(this, 
						android.R.layout.simple_spinner_item,
						Cidades);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spntimes.setAdapter(dataAdapter);

	}
}

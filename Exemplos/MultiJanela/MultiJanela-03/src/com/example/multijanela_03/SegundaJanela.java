package com.example.multijanela_03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaJanela extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segunda_janela);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segunda_janela);
		
		Bundle bundle = getIntent().getExtras();
		String strTxtMsg1 = bundle.getString("idTxtMsg1");
		int iAux = bundle.getInt("idTxtMsg2");
		float fAux = bundle.getFloat("idTxtMsg3");
		
		TextView txtDados = (TextView) findViewById(R.id.idTxtMsg4);
		txtDados.setText("Meu Texto = ["+strTxtMsg1+"] \n"+
		                 "Meu Número = ["+iAux+"] \n" +
		                 "Meu Float = ["+fAux+"]");

	}
}



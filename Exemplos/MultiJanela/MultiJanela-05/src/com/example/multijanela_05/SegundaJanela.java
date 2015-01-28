package com.example.multijanela_05;

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
		
		Bundle myBundle = getIntent().getExtras();
		int[] iArray = getIntent().getIntArrayExtra("iVetor");
		
		TextView txtDados = (TextView) findViewById(R.id.idTxtMsg4);
		txtDados.setText ( "Meu Vetor \n" +
		                   " iArray [0] = " + iArray[0] + "\n" + 
		                   " iArray [1] = " + iArray[1] + "\n" + 
		                   " iArray [2] = " + iArray[2] + "\n" );

	}
}

package com.example.radio_03;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	RadioButton rdiBotao_03;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		rdiBotao_03 = (RadioButton) findViewById(R.id.Botao_03);
		rdiBotao_03.setOnClickListener(Processa_Botao_03);
	}

	View.OnClickListener Processa_Botao_03 = new View.OnClickListener() 
	{
		public void onClick(View v) 
		{
			Toast msg = Toast.makeText ( getBaseContext(), 
										 "Clicado o Terceiro Radio Button", 
										 Toast.LENGTH_LONG);
			msg.show();
		}
	};
	
}
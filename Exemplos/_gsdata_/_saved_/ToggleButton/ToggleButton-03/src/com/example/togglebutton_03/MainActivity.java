package com.example.togglebutton_03;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.Activity;

public class MainActivity extends Activity 
{

	ToggleButton tggBotao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tggBotao = (ToggleButton) findViewById(R.id.toggleButton1);
		tggBotao.setOnClickListener(Processa_Toggle_3);
	}
	
	View.OnClickListener Processa_Toggle_3 = new View.OnClickListener() 
	{
		public void onClick(View v) 
		{
			Toast msg = Toast.makeText ( getBaseContext(), 
										 "Mudou o Estado do Toggle", 
										 Toast.LENGTH_LONG);
			msg.show();
		}
	};
	
}

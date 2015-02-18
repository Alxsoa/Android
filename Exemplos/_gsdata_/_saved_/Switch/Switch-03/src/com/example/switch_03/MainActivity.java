package com.example.switch_03;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity 
{

	Switch swtFlash;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		swtFlash = (Switch) findViewById(R.id.switch2);
		swtFlash.setOnClickListener(Processa_Flash);
	}

	View.OnClickListener Processa_Flash = new View.OnClickListener() 
	{
		public void onClick(View v) 
		{
			Toast.makeText ( getBaseContext(), 
							 "Mudou o Estado do Switch", 
							 Toast.LENGTH_SHORT).show();
		}
	};
	
}
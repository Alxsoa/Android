package com.example.radio_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void ClicadoBotao_03 (View v)
	{
	    Toast.makeText(this, "Clicado o Radio Button 3", Toast.LENGTH_SHORT).show();                
	}
	
}


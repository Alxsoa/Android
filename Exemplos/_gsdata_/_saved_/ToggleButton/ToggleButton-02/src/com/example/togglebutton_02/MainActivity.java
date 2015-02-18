package com.example.togglebutton_02;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void MudancaToggle(View view) 
	{
	    Toast.makeText(this, "Mudou o Estado do Toggle", Toast.LENGTH_SHORT).show();                
	}
}

package com.example.spinner_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends Activity 
{
	Spinner spntimes;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
	}
}
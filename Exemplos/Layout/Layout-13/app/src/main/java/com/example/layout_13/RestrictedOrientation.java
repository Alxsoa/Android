package com.example.layout_13;

import android.app.Activity;
import android.os.Bundle;

public class RestrictedOrientation extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restricted);
	}
}

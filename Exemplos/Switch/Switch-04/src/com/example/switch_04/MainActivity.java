package com.example.switch_04;

import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Switch;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Switch swiFlash = new Switch (this);
		swiFlash.setText("Flash");
		swiFlash.setId(200);
		swiFlash.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
									 LayoutParams.WRAP_CONTENT));
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.MeuLayout);
		layout.addView(swiFlash);
	}   
}


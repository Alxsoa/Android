package com.example.text_01;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity 
{
	TextView txtView;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtView = (TextView) findViewById(R.id.idTextView);
		txtView.setText("Meu Texto Escrito");
	}
}

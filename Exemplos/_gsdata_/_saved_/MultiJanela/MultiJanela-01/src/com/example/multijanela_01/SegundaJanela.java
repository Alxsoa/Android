package com.example.multijanela_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SegundaJanela extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segunda_janela);
		
		Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
		btnVoltar.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				finish();
			}
		});
	}
}

package com.example.multijanela_01;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class PrimeiraJanelaActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira_janela);
	        
        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new OnClickListener() 
	    {			
        	@Override
			public void onClick(View v) 
			{
				Intent request =new Intent ( PrimeiraJanelaActivity.this, SegundaJanela.class);	
				startActivity(request);
			}
		});
	        
	    Button btnSair = (Button) findViewById(R.id.btnSair);
	    btnSair.setOnClickListener(new OnClickListener() 
	    {
	    	@Override
			public void onClick(View v) 
			{
				finish();
			}
		});
	}
}

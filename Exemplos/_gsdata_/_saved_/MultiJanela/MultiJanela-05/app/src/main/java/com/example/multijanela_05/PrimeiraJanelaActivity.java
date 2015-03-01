package com.example.multijanela_05;

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
        
        Button btnIniciar = (Button) findViewById(R.id.idBtnEnvia);
        btnIniciar.setOnClickListener(new OnClickListener() 
        {			
			@Override
			public void onClick(View v) 
			{
				int iVetor [] = { 1, 2, 3 };
				Intent intent = new Intent(PrimeiraJanelaActivity.this, SegundaJanela.class);
				
				Bundle myBundle = new Bundle(); 
				myBundle.putIntArray("iVetor", iVetor);
				intent.putExtras(myBundle);
				startActivity(intent);				
			}
		});
        
    }
}

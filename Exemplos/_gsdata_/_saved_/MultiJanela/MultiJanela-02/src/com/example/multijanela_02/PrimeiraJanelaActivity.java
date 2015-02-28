package com.example.multijanela_02;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class PrimeiraJanelaActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira_janela);   
        
	    Intent iDados = getIntent ();
		if (iDados != null )
		{
			Bundle bDados = iDados.getExtras();
			if (bDados != null )
			{
				String sDados = bDados.getString ("Primaria");			
				TextView txtDados = (TextView) findViewById(R.id.txtPrimario);
				txtDados.setText(" "+sDados);
				bDados = null;
			}
		}
	
        Button btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new OnClickListener() 
        {			
			@Override
			public void onClick(View v) 
			{
				Intent request = new Intent(PrimeiraJanelaActivity.this, SegundaJanela.class);	
				Bundle bDados  = new Bundle();
				bDados.putString("Secundaria", "Janela Principal");
				request.putExtras(bDados);
				finish();
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



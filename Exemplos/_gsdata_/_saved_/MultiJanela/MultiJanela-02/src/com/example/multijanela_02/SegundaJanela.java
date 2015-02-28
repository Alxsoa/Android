package com.example.multijanela_02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SegundaJanela extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segunda_janela);
		
		Intent iDados = getIntent ();
		if (iDados != null )
		{
			Bundle bDados = iDados.getExtras();
			if (bDados != null )
			{
				String sDados = bDados.getString ("Secundaria");
				
	            TextView txtDados = (TextView) findViewById(R.id.txtSecundario);
	            txtDados.setText(" "+sDados);
			}
		}
		
		Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
		btnVoltar.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				Intent request =new Intent(SegundaJanela.this, PrimeiraJanelaActivity.class);	
				Bundle bDados = new Bundle();
				bDados.putString("Primaria", "Janela Secundaria");
				request.putExtras(bDados);
				startActivity(request);
				finish();
			}
		});
	}
}

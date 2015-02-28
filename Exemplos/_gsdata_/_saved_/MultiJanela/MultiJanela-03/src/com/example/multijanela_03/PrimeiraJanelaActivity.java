package com.example.multijanela_03;

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
        
        Button btnIniciar = (Button) findViewById(R.id.idBtnEnvia);
        btnIniciar.setOnClickListener(new OnClickListener() 
        {			
			@Override
			public void onClick(View v) 
			{
				TextView txtMsg1 = (TextView) findViewById(R.id.idTxtMsg1);		
				TextView txtMsg2 = (TextView) findViewById(R.id.idTxtMsg2);
				TextView txtMsg3 = (TextView) findViewById(R.id.idTxtMsg3);
				
				String strAux1 = txtMsg2.getText().toString();
				String strAux2 = txtMsg3.getText().toString();
				
				Intent intent = new Intent(PrimeiraJanelaActivity.this, SegundaJanela.class);
				intent.putExtra("idTxtMsg1", txtMsg1.getText().toString());
				intent.putExtra("idTxtMsg2", Integer.parseInt(strAux1));
				intent.putExtra("idTxtMsg3", Float.valueOf(txtMsg3.getText().toString()));
				startActivity(intent);				
			}
		});
        
    }
}


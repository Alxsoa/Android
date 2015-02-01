package com.example.button_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnEvento = (Button) findViewById(R.id.idBtnBotao);
		btnEvento.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {
        	    TextView txtMsg = (TextView) findViewById(R.id.idTxtMsg);
        	    txtMsg.setText("Escrevi uma Mensagem");	        	
	        }
	    });
	}
}


package com.example.button_04;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnBotao = (Button) findViewById(R.id.idBotao);
		btnBotao.setText( " Meu Texto ");
		btnBotao.setTextColor(Color.BLUE);

		btnBotao.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {
				finish();
	        }
	    });
	}
}
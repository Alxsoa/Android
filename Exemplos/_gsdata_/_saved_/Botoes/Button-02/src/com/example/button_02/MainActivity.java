package com.example.button_02;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	ImageButton imgBotao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imgBotao = (ImageButton) findViewById(R.id.idImgBotao);
		imgBotao.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View viwVisao) 
			{			
			
        	    TextView txtMsg = (TextView) findViewById(R.id.idTxtMsg);
        	    txtMsg.setText(" Escrevi uma Mensagem");	 
			}
 		});
	}

}

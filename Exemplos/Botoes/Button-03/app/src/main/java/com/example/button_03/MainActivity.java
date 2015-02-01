package com.example.button_03;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity 
{
	Button imgBotao;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
	}

	public void addListenerOnButton() 
	{
		imgBotao = (Button) findViewById(R.id.idImgBtn);
		imgBotao.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View viwVisao) 
			{
				Toast.makeText ( MainActivity.this,
								"Botão Foi Clicado e Sua Cor Foi Alterada",
								Toast.LENGTH_SHORT).show();
			}
		});
	}
}
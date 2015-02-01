package com.example.button_07;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.app.Activity;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnMeuBotao = new Button(this);
		btnMeuBotao.setText("Botao #1");
		btnMeuBotao.setId(200);
		btnMeuBotao.setLayoutParams(new LayoutParams( LayoutParams.WRAP_CONTENT,
													  LayoutParams.WRAP_CONTENT));
		
		LinearLayout lnlLayout = (LinearLayout) findViewById(R.id.MeuLayout);
		lnlLayout.addView(btnMeuBotao);
	}   
}
package com.example.radio_04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	 RadioButton 	rdiBotao1, 
	 				rdiBotao3;
	 
	 public void onCreate(Bundle savedInstanceState) 
	 {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.main);
	      
	      rdiBotao1 = (RadioButton)findViewById(R.id.Botao_01);
	      rdiBotao1.setChecked(true);
	      
	      rdiBotao3 = (RadioButton)findViewById(R.id.Botao_03);
	      rdiBotao3.setOnClickListener(myOptionOnClickListener);

	  }

	  RadioButton.OnClickListener myOptionOnClickListener = new RadioButton.OnClickListener()
	  {

		  @Override
		  public void onClick(View v) 
		  {
			  Toast.makeText (	MainActivity.this,
						  		"Opção 3 Foi Selecionada",
						  		Toast.LENGTH_LONG).show();
		  }
	  };
}
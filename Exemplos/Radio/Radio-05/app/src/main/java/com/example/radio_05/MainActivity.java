package com.example.radio_05;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends Activity 
{
	private static final String[] Botoes = { 
												"Opção Botão 01",
												"Opção Botão 02",
												"Opção Botão 03",
												"Opção Botão 04",
												"Opção Botão 05"
											};
	 
	 public void onCreate(Bundle savedInstanceState) 
	 {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.main);
	      DisplayRadioButton();
	  }
	 
	 public void DisplayRadioButton() 
	 {
	       for(int i=0;i<5;i++) 
	       {
	           RadioGroup radiogroup = (RadioGroup)findViewById(R.id.listaBotoes);
	           RadioButton rdiBotao = new RadioButton(this);
	           rdiBotao.setId(i);
	           rdiBotao.setText(Botoes[i]);
	           radiogroup.addView(rdiBotao);
	       }
	  }

}
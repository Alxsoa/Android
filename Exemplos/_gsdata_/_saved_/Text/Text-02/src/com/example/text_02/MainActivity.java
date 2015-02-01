package com.example.text_02;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity 
{
	TextView txtView;
	String sAux1 = "Meu Texto Escrito ";	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtView = (TextView) findViewById(R.id.idTextView01);
		txtView.setTextColor(Color.BLUE);
		txtView.setText(sAux1);
		txtView.setRotation(45);	
		
		txtView = (TextView) findViewById(R.id.idTextView02);
		txtView.setTypeface(null, Typeface.BOLD_ITALIC);
		txtView.setTextColor(Color.GREEN);
		txtView.setText(sAux1);
		txtView.setRotation(135);	
		
		String s = "<b>Texto em Bold</b>, <i>Texto em It‡lico</i>, <u>Sublinhado</u>!";
		txtView = (TextView) findViewById(R.id.idTextView03);
		txtView.setRotation(0);	
		txtView.setText(Html.fromHtml(s));
		
		
		txtView = (TextView) findViewById(R.id.idTextView04);
		txtView.setTypeface(null, Typeface.BOLD);
		txtView.setTextColor(Color.YELLOW);
		txtView.setText(sAux1);
		txtView.setRotation(90);	
		
	}
}

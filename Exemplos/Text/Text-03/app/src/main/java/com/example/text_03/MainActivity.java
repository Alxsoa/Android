package com.example.text_03;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	String sAux1 = "Meu Texto";	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        String fontPath1 = "fonts/CircleD_Font_by_CrazyForMusic.ttf";
        TextView txtView01 = (TextView) findViewById(R.id.idTxtView01);
        Typeface tf1 = Typeface.createFromAsset(getAssets(), fontPath1);
        txtView01.setTypeface(tf1);
		txtView01.setText(sAux1);
       
        String fontPath2 = "fonts/DS-DIGIT.TTF";
        TextView txtView02 = (TextView) findViewById(R.id.idTxtView02);
        Typeface tf2 = Typeface.createFromAsset(getAssets(), fontPath2);
        txtView02.setTypeface(tf2);
        txtView02.setTextSize(20);
		txtView02.setText(sAux1);
 
        String fontPath3 = "fonts/Face Your Fears.ttf";
        TextView txtView03 = (TextView) findViewById(R.id.idTxtView03);
        Typeface tf3 = Typeface.createFromAsset(getAssets(), fontPath3);
        txtView03.setTypeface(tf3); 
        txtView02.setTextSize(40);
		txtView02.setText(sAux1);		
	}
}

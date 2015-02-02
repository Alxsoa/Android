package com.example.display_01;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

//	http://developer.android.com/guide/practices/screens_support.html

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		DisplayMetrics dsmMetrica;
		int iLargura 		= 0;
		int iAltura 		= 0;
		int iDensidade 		= 0;
		double dLargura		= 0.0;
		double dAltura 		= 0.0;
		double dPolegadas 	= 0.0;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//
//		Pegando o Tamanho do Display
//
		dsmMetrica = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dsmMetrica);
		
		iLargura 	= dsmMetrica.widthPixels;
		iAltura		= dsmMetrica.heightPixels;
		iDensidade	= dsmMetrica.densityDpi;
		
		dLargura = (double)iLargura/(double)iDensidade;
		dAltura  = (double)iAltura/(double)iDensidade;
		
		dLargura 	= Math.pow(dLargura,2);
		dAltura 	= Math.pow(dAltura,2);
		
		dPolegadas 	= Math.sqrt(dLargura+dAltura);
		Toast.makeText(this, "Display em Polegadas = "+dPolegadas, Toast.LENGTH_SHORT).show();
	}
}

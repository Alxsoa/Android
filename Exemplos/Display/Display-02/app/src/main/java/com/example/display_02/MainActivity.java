package com.example.display_02;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		DisplayMetrics dsmMetrica;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//
//		Pegando a Densidade do Display
//
		
		dsmMetrica = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dsmMetrica);
		
		switch(dsmMetrica.densityDpi)
		{
		     case 	DisplayMetrics.DENSITY_LOW:
	        		Toast.makeText(this, "Densidade Baixa do Display", Toast.LENGTH_SHORT).show();
		 			break;
		          
		     case 	DisplayMetrics.DENSITY_MEDIUM:
	        		Toast.makeText(this,  "Densidade Média do Display", Toast.LENGTH_SHORT).show();
		 			break;
		          
		     case 	DisplayMetrics.DENSITY_HIGH:
	        		Toast.makeText(this, "Densidade Alta do Display", Toast.LENGTH_SHORT).show();
		 			break;
		 			
		     case 	DisplayMetrics.DENSITY_TV:        		
		    	 	Toast.makeText(this, "Densidade de TV", Toast.LENGTH_SHORT).show();
		 			break;
		 			
		     case 	DisplayMetrics.DENSITY_XHIGH:
	        		Toast.makeText(this,  "Densidade Alta do Display", Toast.LENGTH_SHORT).show();
		 			break;
		 			
		     case 	DisplayMetrics.DENSITY_XXHIGH:
	        		Toast.makeText(this, "Densidade Alta Alta do Display", Toast.LENGTH_SHORT).show();
		 			break;
		 			
		     case 	DisplayMetrics.DENSITY_XXXHIGH:
	        		Toast.makeText(this, "Densidade Alta Alta Alta do Display", Toast.LENGTH_SHORT).show();
		 			break;
		}
	}
}

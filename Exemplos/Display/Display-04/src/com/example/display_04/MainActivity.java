package com.example.display_04;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	int iDensidade = 0;
	int iHpixel = 0;
	int iVpixel = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics ();
        display.getMetrics(outMetrics);
             
        iVpixel = getResources().getDisplayMetrics().heightPixels;
        iHpixel = getResources().getDisplayMetrics().widthPixels;
               
		Toast.makeText(this, "App em Portrait", Toast.LENGTH_SHORT).show();
    }
}

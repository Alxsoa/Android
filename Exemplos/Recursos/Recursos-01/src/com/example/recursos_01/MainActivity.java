package com.example.recursos_01;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.content.res.Resources;

public class MainActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Resources res = getResources();
        int iTempMin = res.getInteger(R.integer.TempMin);
        int iTempMax = res.getInteger(R.integer.TempMax);
        
        Log.d ("MeuLog", "Temperatura Minima = "+iTempMin);
        Log.d ("MeuLog", "Temperatura Maxima = "+iTempMax);
    }
 
}

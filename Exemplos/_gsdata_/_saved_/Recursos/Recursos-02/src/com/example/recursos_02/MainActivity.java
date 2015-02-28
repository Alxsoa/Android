package com.example.recursos_02;

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
        int[] iPrimos = res.getIntArray(R.array.Primos);
        
        Log.d ("[Recursos-01]", "Primo [0] = "+iPrimos[0]);
        Log.d ("[Recursos-01]", "Primo [1] = "+iPrimos[1]);
        Log.d ("[Recursos-01]", "Primo [2] = "+iPrimos[2]);
        Log.d ("[Recursos-01]", "Primo [3] = "+iPrimos[3]);
    }
 
}

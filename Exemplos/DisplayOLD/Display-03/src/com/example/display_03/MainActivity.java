package com.example.display_03;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Configuration;
import android.widget.Toast;

public class MainActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) 
    {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) 
        {
            Toast.makeText(this, "App em Landscape", Toast.LENGTH_SHORT).show();
        } 
        else 
        	if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        	{
        		Toast.makeText(this, "App em Portrait", Toast.LENGTH_SHORT).show();
        	}
    }

    
}

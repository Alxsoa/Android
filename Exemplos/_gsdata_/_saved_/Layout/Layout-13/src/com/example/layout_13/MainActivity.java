package com.example.layout_13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity 
{
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void autoOrientationDetection(View view)
    {
    	Intent intent = new Intent(this, AutomaticOrientation.class);
    	startActivity(intent);
    }

    public void restrictedOrientation(View view)
    {
    	Intent intent = new Intent(this, RestrictedOrientation.class);
    	startActivity(intent);
    }
    
}

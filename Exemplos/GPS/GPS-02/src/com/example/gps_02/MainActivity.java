package com.example.gps_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{	
	Button btnShowLocation;
	GPSTracker gps;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        btnShowLocation.setOnClickListener(new View.OnClickListener() 
        {			
			@Override
			public void onClick(View arg0) 
			{		
		        gps = new GPSTracker(MainActivity.this);
		        if(gps.canGetLocation())
		        {
		        	double dLatitude  = gps.getLatitude();
		        	double dLongitude = gps.getLongitude();
		        	Toast.makeText(getApplicationContext(), "Sua Localização é - \nLat: " + dLatitude + 
		        			                                "\nLong: " + dLongitude, 
		        			                                Toast.LENGTH_LONG).show();	
		        }
		        else
		        {
		        	gps.showSettingsAlert();
		        }				
			}
		});
    }  
}
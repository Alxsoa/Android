package com.example.gps_01;

import android.provider.Settings;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnGpsON = (Button)findViewById(R.id.btnGpsON);
		btnGpsON.setOnClickListener(new View.OnClickListener() 
        {	
	        @Override
	        public void onClick(View arg0) 
	        {
	        	LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
	        	boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
	        	if (!enabled) 
	        	{
	        	  Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	        	  startActivity(intent);
	        	}	        	
	        }
        });
		
		Button btnGpsOFF = (Button)findViewById(R.id.btnGpsOFF);
		btnGpsOFF.setOnClickListener(new View.OnClickListener() 
        {	
	        @Override
	        public void onClick(View arg0) 
	        {
	        	LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
	        	boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
	        	if (enabled) 
	        	{
	        	  Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	        	  startActivity(intent);
	        	}	          	
			}
        });		
	}
}

package com.example.wifi_04;

import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Global;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{			
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnAirPlaneCheck = (Button)findViewById(R.id.idAirplaneCheck);
		btnAirPlaneCheck.setOnClickListener(new View.OnClickListener() 
        {	
	        @Override
	        public void onClick(View arg0) 
	        {
	        	boolean isEnabled = Settings.System.getInt(getContentResolver(),Global.AIRPLANE_MODE_ON, 0) != 0;        	
	        	TextView txtMsg = (TextView) findViewById(R.id.idTxtMsg);
	        	if (isEnabled) 
	        	{ 
	        		txtMsg.setText("Est‡ em Modo Avi‹o");
	        	}
	        	else
	        	{
	        		txtMsg.setText("N‹o Est‡ em Modo Avi‹o");	        		
	        	}

			}
        });		
	}
}

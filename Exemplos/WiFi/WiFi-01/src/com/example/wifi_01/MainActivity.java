package com.example.wifi_01;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnWifiON = (Button)findViewById(R.id.btnWifiON);
		btnWifiON.setOnClickListener(new View.OnClickListener() 
        {	
	        @Override
	        public void onClick(View arg0) 
	        {
	        	WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	        	wifi.setWifiEnabled(true);
			}
        });
		
		Button btnWifiOFF = (Button)findViewById(R.id.btnWifiOFF);
		btnWifiOFF.setOnClickListener(new View.OnClickListener() 
        {	
	        @Override
	        public void onClick(View arg0) 
	        {
	        	WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	        	wifi.setWifiEnabled(false);
			}
        });
		
	}
}

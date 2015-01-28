package com.example.wifi_03;

import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

public class MainActivity extends Activity 
{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{			
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	        		        	
    	ConnectivityManager connManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
    	WifiManager wifiManager = (WifiManager)getSystemService(Context.WIFI_SERVICE);
    	WifiInfo wifiInfo = wifiManager.getConnectionInfo();	        	        		        	
    	int ipAddress = wifiInfo.getIpAddress();
        
    	String strSSID = wifiInfo.getSSID();
    	String strMacAdd = wifiInfo.getMacAddress();
        String strNumIP = String.format ( "%d.%d.%d.%d", 
							                (ipAddress & 0xff),
							                (ipAddress >> 8 & 0xff), 
							                (ipAddress >> 16 & 0xff),
							                (ipAddress >> 24 & 0xff));
        
		TextView txtNetDados = (TextView) findViewById(R.id.idNetDados);
		txtNetDados.setText("Numero Ip = "+strNumIP+"\n"+
							"Endereço Mac = "+strMacAdd+"\n"+
							"SSID = "+strSSID);	

	}
}

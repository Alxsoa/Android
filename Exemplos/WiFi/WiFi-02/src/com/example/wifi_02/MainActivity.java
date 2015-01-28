package com.example.wifi_02;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
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
		
		Button btnCnx3g = (Button)findViewById(R.id.btnCnx3g);
		btnCnx3g.setOnClickListener(new View.OnClickListener() 
        {	
	        @Override
	        public void onClick(View arg0) 
	        {
	        	ConnectivityManager cncServico = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
	        	boolean is3G = cncServico.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnectedOrConnecting();	        	
	        	
	        	TextView txtView1 = (TextView) findViewById(R.id.txtMsg);
	        	if (is3G) 
	        	{ 
	        		txtView1.setText("Conex‹o 3G Est‡ Conectada");
	        	}
	        	else
	        	{
	        		txtView1.setText("Conex‹o 3G N‹o Est‡ Conectada");	        		
	        	}

			}
        });
		
		Button btnCnxWifi = (Button)findViewById(R.id.btnCnxWifi);
		btnCnxWifi.setOnClickListener(new View.OnClickListener() 
        {	
	        @Override
	        public void onClick(View arg0) 
	        {
	        	ConnectivityManager cncServico = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
	        	boolean WiFi = cncServico.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnectedOrConnecting();	        	
	        	
	        	TextView txtView1 = (TextView) findViewById(R.id.txtMsg);
	        	if (WiFi) 
	        	{ 
	        		txtView1.setText("Conex‹o WiFi Est‡ Conectada");
	        	}
	        	else
	        	{
	        		txtView1.setText("Conex‹o WiFi N‹o Est‡ Conectada");	        		
	        	}
			}
        });	
	}
}

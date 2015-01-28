package com.example.webkit_01;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	WifiManager wfiConexao;
	WifiInfo wfiInformacao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		WebView	wbvAcesso = new WebView (this);
		WebSettings wbsConfig = wbvAcesso.getSettings();
		
		ConnectivityManager CManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo NInfo = CManager.getActiveNetworkInfo();
		
		if (NInfo != null && NInfo.isConnectedOrConnecting())
        {
			wbsConfig.setSaveFormData(false);		
			wbsConfig.setJavaScriptEnabled(true);		
			wbsConfig.setSupportZoom(true);	
			wbvAcesso.loadUrl("http://www.amazon.com");
			setContentView(wbvAcesso);		
        }
		else 
		{
			Toast.makeText( getApplicationContext(),"N‹o Existe Rede Disponível",Toast.LENGTH_LONG).show();
		}
	}
}



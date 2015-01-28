package com.example.telefone_03;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity 
{

	public String text="Helloo";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnNumero = (Button) findViewById(R.id.btnNumero);
		btnNumero.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {
	        	TelephonyManager mTelephonyMgr;
	        	mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
	        	String mNumero = mTelephonyMgr.getLine1Number(); 
	        	
	        	TextView tv = (TextView) findViewById(R.id.txtView);
				tv.setText(mNumero);	        	
	        }
	    });
	}



}

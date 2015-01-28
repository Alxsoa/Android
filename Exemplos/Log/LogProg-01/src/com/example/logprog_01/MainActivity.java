package com.example.logprog_01;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity 
{
	String TAB = "MeuLog";
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button bVerbose = (Button) findViewById(R.id.btnVerbose);
		bVerbose.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View view) 
			{
				Log.v (TAB, "Msg From Verbose");
			}
		});
		
		Button bDebug = (Button) findViewById(R.id.btnDebug);
		bDebug.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View view) 
			{
				Log.d (TAB, "Msg From Debug");
			}
		});
		
		Button bInfo = (Button) findViewById(R.id.btnInfo);
		bInfo.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View view) 
			{
				Log.i (TAB, "Msg From Info");
			}
		});
	
		Button bWarning = (Button) findViewById(R.id.btnWarning);
		bWarning.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View view) 
			{
				Log.w (TAB, "Msg From Warning");
			}
		});
	}
}

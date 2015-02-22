package com.example.progressbar_03;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity 
{

	private static final int REFRESH_SCREEN = 1;
	ProgressBar Progress;
	TextView txtView;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Progress = (ProgressBar) findViewById(R.id.progressBar1);
        
        txtView = (TextView) findViewById(R.id.textView1);
        txtView.setVisibility(View.INVISIBLE); 
        
        startScan(); 
    }
    
	public void startScan() 
	{
		new Thread() 
		{
			public void run() 
			{					
				try
				{			
					Thread.sleep(5000);
					hRefresh.sendEmptyMessage(REFRESH_SCREEN);
				}
				catch(Exception e)
				{
				}
			}
		}.start();
	}

	Handler hRefresh = new Handler()
	{
		public void handleMessage(Message msg) 
		{
			switch(msg.what)
			{
				case 	REFRESH_SCREEN:
						Progress.setVisibility(View.INVISIBLE); 
						ShowText();
						break;
				default:
						break;
			}
		}
	};
	
	public void ShowText() 
	{
		txtView.setText("Bem Vindo a Minha Aplicação");
		txtView.setVisibility(View.VISIBLE);
	}

}

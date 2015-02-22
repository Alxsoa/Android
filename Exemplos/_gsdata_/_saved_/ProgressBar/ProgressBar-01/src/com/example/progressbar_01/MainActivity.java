package com.example.progressbar_01;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity 
{

	Button btnStartProgress;
	ProgressDialog progressBar;
	private int progressBarStatus = 0;
	private Handler progressBarHandler = new Handler();

	private long fileSize = 0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
	}

	public void addListenerOnButton() 
	{
		btnStartProgress = (Button) findViewById(R.id.btnStartProgress);
		btnStartProgress.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				progressBar = new ProgressDialog(v.getContext());
				progressBar.setCancelable(true);
				progressBar.setMessage("Transferindo ...");
				progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progressBar.setProgress(0);
				progressBar.setMax(100);
				progressBar.show();

				progressBarStatus = 0;
				fileSize = 0;
				
				new Thread(new Runnable() 
				{
					public void run() 
					{
						while (progressBarStatus < 100) 
						{
							progressBarStatus = doSomeTasks();

							try 
							{
								Thread.sleep(1000);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}

							progressBarHandler.post(new Runnable() 
							{
								public void run() 
								{
									progressBar.setProgress(progressBarStatus);
								}
							});
						}

						if (progressBarStatus >= 100) 
						{
							try 
							{
								Thread.sleep(2000);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
							progressBar.dismiss();
						}
					}
				}).start();
			}
		});
	}

	public int doSomeTasks() 
	{
		while (fileSize <= 1000000) 
		{
			fileSize++;

			if (fileSize == 100000) 
			{
				return 10;
			} 
			else 
				if (fileSize == 200000) 
				{
					return 20;
				} 
				else 
					if (fileSize == 300000) 
					{
						return 30;
					}
		}
		return 100;
	}
}
package com.example.service_02;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MeuServico extends Service 
{
	private static final String TAG = "MyService";
	MediaPlayer player;
	
	@Override
	public IBinder onBind(Intent intent) 
	{
		return null;
	}
	
	@Override
	public void onCreate() 
	{
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
		
		player = MediaPlayer.create(this, R.raw.braincandy);
		player.setLooping(false); 
	}

	@Override
	public void onDestroy() 
	{
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
		player.stop();
	}
	
	@Override
	public void onStart(Intent intent, int startid) 
	{
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
		player.start();
	}
}
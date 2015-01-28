package com.example.touch_01;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.app.Activity;

public class MainActivity extends Activity 
{
	String TAG = "MeuLog";
	
	@Override
	public boolean onTouchEvent(MotionEvent event) 
	{
		switch (event.getAction()) 
		{
			case	MotionEvent.ACTION_DOWN:
					Log.v (TAG, "Ação DOWN");
					return true;
					
			case 	MotionEvent.ACTION_MOVE:
					Log.v (TAG, "Ação MOVE");
					break;
					
			case 	MotionEvent.ACTION_UP:
					Log.v (TAG, "Ação UP");				
					break;
					
			default:
				return false;
		}
	
		return true;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	}

}
package com.example.surfaceview_02;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity implements OnTouchListener 
{
	
	exampleView v;
	Bitmap Android_icon; 
	float x, y;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		v = new exampleView(this);
		v.setOnTouchListener(this);
		Android_icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		//x = y = 0;

		x = (Android_icon.getWidth()/2);
		y = (Android_icon.getHeight()/2);
		setContentView(v);
		
	}	
	
	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
		
	}

	@Override
	protected void onResume() 
	{
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
		
	}

	public class exampleView extends SurfaceView implements Runnable 
	{
		
		Thread t = null;
		SurfaceHolder holder;
		boolean Working = false;
		

		public exampleView(Context context) 
		{
			super(context);
			holder = getHolder();
		}

		@Override
		public void run() 
		{
			while(Working == true)
			{
				if(!holder.getSurface().isValid())
				{
					continue;					
				}
				Canvas c = holder.lockCanvas();
				c.drawARGB(255, 255, 255, 255);
				c.drawBitmap(Android_icon, x - (Android_icon.getWidth()/2), y - (Android_icon.getHeight()/2), null);
				holder.unlockCanvasAndPost(c);								 
			}			
		}
		
		public void pause() 
		{
			Working = false;
			while(true)
			{				
				try 
				{
					t.join();
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				break;
			}
			t = null;			
		}
		
		public void resume() 
		{
			Working = true;
			t = new Thread(this);
			t.start();			
		}		
	}

	@Override
	public boolean onTouch(View v, MotionEvent me) 
	{	
		try 
		{
			Thread.sleep(50);
		} 
		catch (Exception e) 
		{
		}
		
		switch (me.getAction())
		{
			case 	MotionEvent.ACTION_DOWN:
					x = me.getX();
					y = me.getY();			
					break;
						
			case 	MotionEvent.ACTION_UP:
					x = me.getX();
					y = me.getY();			
					break;
						
			case 	MotionEvent.ACTION_MOVE:
					x = me.getX();
					y = me.getY();			
					break;		
		}		
		return true;
	}	
}
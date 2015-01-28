package com.example.surfaceview_01;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SurfaceViewActivity extends Activity implements Runnable 
{
	private Button swapBtn;
	private SurfaceView surface;
	private SurfaceHolder holder;
	private boolean locker=true;
	private Thread thread;
	private int radiusBlack, radiusWhite;
	private boolean left = true;

	private static final int baseRadius = 10;
	private static final int maxRadius = 50;
	private static final int baseSpeed = 1;
	private int speed = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        
        swapBtn = (Button) findViewById(R.id.buttonswap);
        
        surface = (SurfaceView) findViewById(R.id.mysurface);
        holder = surface.getHolder();
        
        thread = new Thread(this);
        thread.start();
        swapBtn.setOnClickListener(new OnClickListener() 
        {			
			@Override
			public void onClick(View arg0) 
			{
				left = !left;
			}
		});
    }
  
	@Override
	public void run() 
	{
		while(locker)
		{
			if(!holder.getSurface().isValid())
			{
				continue;
			}
			
			Canvas canvas = holder.lockCanvas();
			draw(canvas);
			holder.unlockCanvasAndPost(canvas);
		}
	}
	
	private void draw(Canvas canvas) 
	{
		canvas.drawColor(android.R.color.holo_blue_bright);
		int border = 20;
		RectF r = new RectF(border, border, canvas.getWidth()-20, canvas.getHeight()-20);
		Paint paint = new Paint();		
		paint.setARGB(200, 135, 135, 135); //paint color GRAY+SEMY TRANSPARENT 
		canvas.drawRect(r , paint );
		
		calculateRadiuses();
		paint.setColor(getResources().getColor(android.R.color.black));
		canvas.drawCircle(canvas.getWidth()/4, canvas.getHeight()/2, radiusBlack, paint);
		
		paint.setColor(getResources().getColor(android.R.color.white));
		canvas.drawCircle(canvas.getWidth()/4*3, canvas.getHeight()/2, radiusWhite, paint);
	}

	private void calculateRadiuses() 
	{
		if(left)
		{
			updateSpeed(radiusBlack);
			radiusBlack += speed;
			radiusWhite = baseRadius;
		}
		else
		{
			updateSpeed(radiusWhite);
			radiusWhite += speed;
			radiusBlack = baseRadius;
		}
	}

	private void updateSpeed(int radius) 
	{
		if(radius>=maxRadius)
		{
			speed = -baseSpeed;
		}
		else if (radius<=baseRadius)
		{
			speed = baseSpeed;
		}
	}

	@Override
	protected void onPause() 
	{		
		super.onPause();
		pause();
	}
	
	private void pause() 
	{
		locker = false;
		while(true)
		{
			try 
			{
				thread.join();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			break;
		}
		thread = null;
	}

	@Override
	protected void onResume() 
	{
		super.onResume();
		resume();		
	}

	private void resume() 
	{
		locker = true;
		thread = new Thread(this);
		thread.start();
	}
}

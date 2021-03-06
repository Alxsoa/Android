package com.example.surfaceview_03;

import java.io.IOException;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class AndroidCamera extends Activity implements SurfaceHolder.Callback{

	Camera camera;
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	boolean previewing = false;;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button buttonStartCameraPreview = (Button)findViewById(R.id.startcamerapreview);
        Button buttonStopCameraPreview = (Button)findViewById(R.id.stopcamerapreview);
        
        getWindow().setFormat(PixelFormat.UNKNOWN);
        surfaceView = (SurfaceView)findViewById(R.id.surfaceview);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        
        buttonStartCameraPreview.setOnClickListener(new Button.OnClickListener()
        {
			@Override
			public void onClick(View v) 
			{
				if(!previewing)
				{
					camera = Camera.open();
					if (camera != null){
						try 
						{
							camera.setPreviewDisplay(surfaceHolder);
							camera.startPreview();
							previewing = true;
						} 
						catch (IOException e) 
						{
							e.printStackTrace();
						}
					}
				}
			}});
        
        buttonStopCameraPreview.setOnClickListener(new Button.OnClickListener()
        {
			@Override
			public void onClick(View v) 
			{
				if(camera != null && previewing)
				{
					camera.stopPreview();
					camera.release();
					camera = null;
					previewing = false;
				}
			}
		});      
    }
    
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) 
	{
	
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) 
	{
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) 
	{
		
	}
}
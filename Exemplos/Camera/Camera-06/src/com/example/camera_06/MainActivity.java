package com.example.camera_06;

import java.io.IOException;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements SurfaceHolder.Callback
{
	Camera 			cmrCamera;
	SurfaceView 	srfViewBase;
	SurfaceHolder 	srfViewHolder;
	boolean 		bPreview = false;
	LayoutInflater 	lytMeuLayout = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        srfViewBase = (SurfaceView)findViewById(R.id.idCameraPreview);
        srfViewHolder = srfViewBase.getHolder();
        srfViewHolder.addCallback(this);
                     
    	Button btnNormal = (Button) findViewById(R.id.idCaptura);
    	btnNormal.setOnClickListener( new View.OnClickListener()
    	{
            @Override
            public void onClick(View v) 
            {
				Toast.makeText(getApplicationContext(),"Reação do Botão",Toast.LENGTH_LONG).show();
            }
        });       
    }       

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) 
	{
		if(bPreview)
		{
			cmrCamera.stopPreview();
			bPreview = false;
		}
		
		if (cmrCamera != null)
		{
			try 
			{
				cmrCamera.setPreviewDisplay(srfViewHolder);
				cmrCamera.startPreview();
				bPreview = true;
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder sfhControle) 
	{
		cmrCamera = Camera.open();
	    try 
	    {
	      cmrCamera.setPreviewDisplay(sfhControle);
	      Camera.Parameters parameters = cmrCamera.getParameters();
	      if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) 
	      {
	        parameters.set("orientation", "portrait");
	        cmrCamera.setDisplayOrientation(90);
	      } 
	    } 
	    catch (IOException exception) 
	    {
	      cmrCamera.release();
	    }
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) 
	{
		cmrCamera.stopPreview();
		cmrCamera.release();
		cmrCamera = null;
		bPreview = false;
	}
}
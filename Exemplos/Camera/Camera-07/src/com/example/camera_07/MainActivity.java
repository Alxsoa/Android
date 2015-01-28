package com.example.camera_07;

import android.os.Bundle;
import android.app.Activity;
import java.io.IOException;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements SurfaceHolder.Callback 
{
  String 		TAG = "MeuLog";
  SurfaceView 	sfvCamera;
  SurfaceHolder sfhAcesso;
  Camera 		cmrCamera;
  Boolean 		bCamera = false;
  
  @Override
  protected void onDestroy() 
  {
      super.onDestroy();
      if (bCamera) 
      { 
    	  cmrCamera.release(); 
      }
  }

  @Override
  protected void onPause() 
  {
      super.onPause();
      if (bCamera) 
      { 
    	  cmrCamera.stopPreview();
      }
  }
  
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    sfvCamera = (SurfaceView) this.findViewById(R.id.CameraView);
    sfhAcesso = sfvCamera.getHolder();
    sfhAcesso.addCallback(this);
 
	Button btnNormal = (Button) findViewById(R.id.idBtnNormal);
	btnNormal.setOnClickListener( new View.OnClickListener()
	{
        @Override
        public void onClick(View v) 
        {
            Camera.Parameters parameters = cmrCamera.getParameters();
        	parameters.setColorEffect(Camera.Parameters.EFFECT_NONE);
    	    cmrCamera.setParameters(parameters); 
        }
    });
    
	Button btnSolar = (Button) findViewById(R.id.idBtnSolar);
	btnSolar.setOnClickListener( new View.OnClickListener()
	{
        @Override
        public void onClick(View v) 
        {
            Camera.Parameters parameters = cmrCamera.getParameters();
        	parameters.setColorEffect(Camera.Parameters.EFFECT_SOLARIZE);
    	    cmrCamera.setParameters(parameters); 
        }
    });
	
	Button btnNegativo = (Button) findViewById(R.id.idBtnNegativo);
	btnNegativo.setOnClickListener( new View.OnClickListener()
	{
        @Override
        public void onClick(View v) 
        {
            Camera.Parameters parameters = cmrCamera.getParameters();
        	parameters.setColorEffect(Camera.Parameters.EFFECT_NEGATIVE);
    	    cmrCamera.setParameters(parameters); 
        }
    });
  }
  
  public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) 
  {
    cmrCamera.startPreview();
  }

  public void surfaceCreated(SurfaceHolder sfhControle) 
  {
    cmrCamera = Camera.open();
    try 
    {
    	bCamera = true;
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
  
  public void surfaceDestroyed(SurfaceHolder holder) 
  {
    cmrCamera.stopPreview();
    cmrCamera.release();
  }
}

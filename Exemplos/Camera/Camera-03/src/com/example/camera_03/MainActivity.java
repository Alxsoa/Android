package com.example.camera_03;

import android.os.Bundle;
import android.app.Activity;
import java.io.IOException;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends Activity implements SurfaceHolder.Callback 
{
  SurfaceView 	sfvCamera;
  SurfaceHolder sfhAcesso;
  Camera 		cmrCamera;
  int			iNumCameras = 0;
  int			iCamera = 0;
  
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    iNumCameras = Camera.getNumberOfCameras();
    CameraInfo cameraInfo = new CameraInfo();
    for (int iAux = 0; iAux < iNumCameras; iAux++) 
    {
        Camera.getCameraInfo(iAux, cameraInfo);
        if (cameraInfo.facing == CameraInfo.CAMERA_FACING_BACK) 
        {
        	iCamera = iAux;
        }
    }
    
    sfvCamera = (SurfaceView) this.findViewById(R.id.CameraView);
    sfhAcesso = sfvCamera.getHolder();
    sfhAcesso.addCallback(this);
  }
  
  public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) 
  {
    cmrCamera.startPreview();
  }

  public void surfaceCreated(SurfaceHolder sfhControle) 
  {
	cmrCamera = Camera.open(iCamera);  

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
  
  public void surfaceDestroyed(SurfaceHolder holder) 
  {
    cmrCamera.stopPreview();
    cmrCamera.release();
  }
}

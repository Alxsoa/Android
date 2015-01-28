package com.example.camera_04;

import android.os.Bundle;
import android.app.Activity;
import java.io.IOException;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

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
       
    sfvCamera = (SurfaceView) this.findViewById(R.id.CameraView);
    sfhAcesso = sfvCamera.getHolder();
    sfhAcesso.addCallback(this);
    
	Button btnFrontal = (Button) findViewById(R.id.idBtnFrontal);
	btnFrontal.setOnClickListener( new View.OnClickListener()
	{
        @Override
        public void onClick(View v) 
        {
            cmrCamera.stopPreview();
            cmrCamera.release();
            
            iNumCameras = Camera.getNumberOfCameras();
            CameraInfo cameraInfo = new CameraInfo();
            for (int iAux = 0; iAux < iNumCameras; iAux++) 
            {
                Camera.getCameraInfo(iAux, cameraInfo);
                if (cameraInfo.facing == CameraInfo.CAMERA_FACING_FRONT) 
                {
                	iCamera = iAux;
                }
            }
        	
        	cmrCamera = Camera.open(iCamera); 
        	try 
        	{
				cmrCamera.setPreviewDisplay(sfhAcesso);
			} 
        	catch (IOException e) 
        	{
				e.printStackTrace();
			}
            cmrCamera.startPreview();
        }
    });
	
	Button btnTrazeira = (Button) findViewById(R.id.idBtnTrazeira);
	btnTrazeira.setOnClickListener( new View.OnClickListener()
	{
        @Override
        public void onClick(View v) 
        {
            cmrCamera.stopPreview();
            cmrCamera.release();
            
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
        	
        	cmrCamera = Camera.open(iCamera); 
        	try 
        	{
				cmrCamera.setPreviewDisplay(sfhAcesso);
			} 
        	catch (IOException e) 
        	{
				e.printStackTrace();
			}
            cmrCamera.startPreview();
        }
    });
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

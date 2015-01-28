package com.example.camera_08;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import java.io.IOException;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Paint;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity 
{
	@Override  
	protected void onCreate(Bundle savedInstanceState)  
	{  
	    super.onCreate(savedInstanceState);  
	    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);  
	    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);  
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  
	    requestWindowFeature(Window.FEATURE_NO_TITLE);  
	    setContentView(new CameraShow(this));  
	}

	@SuppressLint("NewApi") 
	public class CameraShow extends SurfaceView implements SurfaceHolder.Callback, Camera.PictureCallback
	{
		String	TAG = "MeuLog";
		private SurfaceHolder	holder;
		private Camera			camera;
		@SuppressWarnings("unused")
		private Context			context;
		private Paint 			paint 		= new Paint();
		
		private long			firstPoint;
		private long			secondPoint;

		@SuppressWarnings("deprecation")
		CameraShow(Context context)
		{
			super(context);
			this.context = context;

			holder = getHolder();
			holder.addCallback(this);
			holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder)
		{
			try
			{
				camera = Camera.open(0);
				camera.setDisplayOrientation(90); // Rotates Camera's preview 90 degrees
				camera.setPreviewDisplay(holder);
			}
			catch (IOException e)
			{
			}
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
		{
			camera.startPreview();
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder)
		{
			camera.setPreviewCallback(null);
			camera.stopPreview();
			camera.release();
			camera = null;
		}

		@Override
		public boolean onTouchEvent(MotionEvent event)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN)
				camera.takePicture(null, null, this);

			return true;
		}

		public void onPictureTaken(byte[] data, Camera camera)
		{
			camera.startPreview();
		}
	
	}
}

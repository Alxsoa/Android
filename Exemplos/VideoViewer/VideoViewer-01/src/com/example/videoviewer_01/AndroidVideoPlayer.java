package com.example.videoviewer_01;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class AndroidVideoPlayer extends Activity implements SurfaceHolder.Callback
{
	MediaPlayer mediaPlayer;
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	boolean pausing = false;;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button buttonPlayVideo = (Button)findViewById(R.id.playvideoplayer);      
        getWindow().setFormat(PixelFormat.UNKNOWN); 
        VideoView mVideoView = (VideoView)findViewById(R.id.videoview);
          
        String uriPath = "android.resource://com.example.videoviewer_01/"+R.raw.k;
		Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();

        buttonPlayVideo.setOnClickListener(new Button.OnClickListener()
        {
			@Override
			public void onClick(View v) 
			{
				VideoView mVideoView = (VideoView)findViewById(R.id.videoview);
		        String uriPath = "android.resource://com.example.videoviewer_01/"+R.raw.k;
				Uri uri = Uri.parse(uriPath);
		        mVideoView.setVideoURI(uri);
		        mVideoView.requestFocus();
		        mVideoView.start();				
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
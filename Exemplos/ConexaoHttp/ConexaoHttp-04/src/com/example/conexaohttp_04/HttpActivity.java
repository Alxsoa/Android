package com.example.conexaohttp_04;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class HttpActivity extends Activity 
{

	private ImageView image;
	private TextView text;
	
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        image = (ImageView) findViewById(R.id.image);
        text = (TextView) findViewById(R.id.text);
        
        downloadTwitterIcon();
        //downloadTwitterStream();
    }
    
	public void downloadTwitterIcon() 
	{
		Handler handler = new Handler() 
		{
			public void handleMessage(Message message) 
			{
				switch (message.what) 
				{
					case 	HttpConnection.DID_START: 
							{
								Log.d("Image", "Starting Connection");
								break;
							}
							
					case 	HttpConnection.DID_SUCCEED: 
							{
								Bitmap response = (Bitmap) message.obj;
								image.setImageBitmap(response);
								break;
							}
							
					case 	HttpConnection.DID_ERROR: 
							{
								Exception e = (Exception) message.obj;
								e.printStackTrace();
								break;
							}
				}
			}
		};
		new HttpConnection(handler).bitmap("http://192.168.25.24:8888/rio.png");
	}
}
package com.example.conexaohttp_02;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity 
{
    
	private ProgressDialog progressDialog;	
	private Bitmap bitmap = null;
	private String text = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        
       Button btnImagem = (Button)findViewById(R.id.idBtnDownload);       
       btnImagem.setOnClickListener( new OnClickListener() 
       {
			public void onClick(View v) 
			{
				downloadImage("http://192.168.25.24:8888/rio.png");			
			}
        });
    }
    
	private void downloadImage(String urlStr) 
	{
		progressDialog = ProgressDialog.show(this, "","Imgem Sendo Baixada de " + urlStr);
		final String url = urlStr;
		
		new Thread() 
		{
			public void run() 
			{
				InputStream in = null;
				Message msg = Message.obtain();
				msg.what = 1;
				try 
				{
				    in = openHttpConnection(url);
				    bitmap = BitmapFactory.decodeStream(in);
				    Bundle b = new Bundle();
				    b.putParcelable("bitmap", bitmap);
				    msg.setData(b);
				    in.close();
				} 
				catch (IOException e1) 
				{
				    e1.printStackTrace();
				}
				messageHandler.sendMessage(msg);					
			}
 		}.start();
	}
		
	private InputStream openHttpConnection(String urlStr) 
	{
		InputStream in = null;
		int resCode = -1;
		
		try 
		{		
			URL url = new URL(urlStr);
			URLConnection urlConn = url.openConnection();
			
			if (!(urlConn instanceof HttpURLConnection)) 
			{
				throw new IOException ("URL is not an Http URL");
			}
			
			HttpURLConnection httpConn = (HttpURLConnection)urlConn;
			httpConn.setAllowUserInteraction(false);
	        httpConn.setInstanceFollowRedirects(true);
	        httpConn.setRequestMethod("GET");
	        httpConn.connect(); 
	
	        resCode = httpConn.getResponseCode();                 
	        if (resCode == HttpURLConnection.HTTP_OK) 
	        {
	            in = httpConn.getInputStream();                                 
	        }         
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return in;
	}
	
	private Handler messageHandler = new Handler() 
	{		
		public void handleMessage(Message msg) 
		{
			super.handleMessage(msg);

			ImageView img = (ImageView) findViewById(R.id.idImgFigura);
			img.setImageBitmap((Bitmap)(msg.getData().getParcelable("bitmap")));
			progressDialog.dismiss(); 
		}
	};
}
package com.example.conexaohttp_03;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import android.widget.TextView;

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
        
        Button textBtn = (Button)findViewById(R.id.idBtnTexto);
        textBtn.setOnClickListener(new OnClickListener() 
        {
			public void onClick(View v) 
			{
				downloadText("http://192.168.25.24:8888/Texto.txt");
			}
        });
    }
   
	private void downloadText(String urlStr) 
	{
		progressDialog = ProgressDialog.show(this, "","Download Text from " + urlStr);
		final String url = urlStr;
		
		new Thread () 
		{
			public void run() 
			{
				int BUFFER_SIZE = 2000;
		        InputStream in = null;
		        Message msg = Message.obtain();
		        msg.what=2;
		        try 
		        {
		        	in = openHttpConnection(url);
		            
		            InputStreamReader isr = new InputStreamReader(in);
		            int charRead;
		              text = "";
		              char[] inputBuffer = new char[BUFFER_SIZE];

	                  while ((charRead = isr.read(inputBuffer))>0)
	                  {                    
	                      String readString = String.copyValueOf(inputBuffer, 0, charRead);                    
	                      text += readString;
	                      inputBuffer = new char[BUFFER_SIZE];
	                  }
		                  
	                 Bundle b = new Bundle();
					 b.putString("text", text);
					 msg.setData(b);
	                 in.close();
	                  
				}
		        catch (IOException e2) 
		        {
	                e2.printStackTrace();
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

			TextView text = (TextView) findViewById(R.id.idTxtTexto);
			text.setText(msg.getData().getString("text"));
			progressDialog.dismiss(); 
		}
	};
}
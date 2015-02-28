package com.example.webkit_01b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
 
@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity 
{
    WebView web;
 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
 
        web = (WebView) findViewById(R.id.webview01);  
        web.setWebViewClient(new myWebClient() 
        {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) 
            {
                super.onReceivedError(view, errorCode, description, failingUrl);
                web.loadUrl("http://www.amazon.com");
            }
         });
        
        web.getSettings().setSaveFormData(false);		
        web.getSettings().setJavaScriptEnabled(true);		
		web.getSettings().setSupportZoom(false);
		web.loadUrl("http://nao.vai.pra.lugar.nenhum.com");
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) 
        {
            super.onPageStarted(view, url, favicon);
        }
        
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) 
        {
            view.loadUrl(url);
            return true;
        }
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
     if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) 
     {
         web.goBack();
         return true;
     }
     return super.onKeyDown(keyCode, event);
    }
}
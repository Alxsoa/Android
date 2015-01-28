package com.example.intent_02;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 
{
    
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Button BtnView = (Button) findViewById(R.id.idBtnView);
      BtnView.setOnClickListener(new View.OnClickListener() 
      {
         public void onClick(View view) 
         {
            Intent ittView = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com"));
            startActivity(ittView);
         }
      });

      Button startBrowser_b = (Button) findViewById(R.id.idBtnLaunch);
      startBrowser_b.setOnClickListener(new View.OnClickListener() 
      {
         public void onClick(View view) 
         {
            Intent i = new Intent("com.example.intent_02.LAUNCH", Uri.parse("http://www.amazon.com"));
            startActivity(i);
         }
      });
   }  
}
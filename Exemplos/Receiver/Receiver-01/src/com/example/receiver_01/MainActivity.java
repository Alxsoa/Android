package com.example.receiver_01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity 
{

   @Override
   public void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   }

   public void BroadcastMsg (View view)
   {
      Intent intent = new Intent();
      intent.setAction("com.example.receiver_01.CUSTOM_INTENT");
      sendBroadcast(intent);
   }
}
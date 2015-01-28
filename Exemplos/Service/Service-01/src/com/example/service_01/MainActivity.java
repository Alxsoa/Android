package com.example.service_01;

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

   public void startService(View view) 
   {
      startService(new Intent(getBaseContext(), MeuServico.class));
   }

   public void stopService(View view) 
   {
      stopService(new Intent(getBaseContext(), MeuServico.class));
   }
}
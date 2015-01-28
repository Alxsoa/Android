package com.example.receiver_02;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity 
{

   @Override
   public void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
   }

   public void CancelaBroadcastMsg (View view)
   {
	   PackageManager pcmPacote = getPackageManager();
	   ComponentName compName = new ComponentName(getApplicationContext(), MeuReceptor.class);
	   pcmPacote.setComponentEnabledSetting (	compName,
			   									PackageManager.COMPONENT_ENABLED_STATE_DISABLED, 
			   									PackageManager.DONT_KILL_APP);
	   Toast.makeText(getApplicationContext(), "Intent Cancelado", Toast.LENGTH_LONG).show();
   }
   
   public void BroadcastMsg (View view)
   {
	   PackageManager pcmPacote = getPackageManager();
	   ComponentName compName = new ComponentName(getApplicationContext(), MeuReceptor.class);
	   pcmPacote.setComponentEnabledSetting (	compName,
			   									PackageManager.COMPONENT_ENABLED_STATE_ENABLED, 
			   									PackageManager.DONT_KILL_APP); 
	   
      Intent intent = new Intent();
      intent.setAction("com.example.receiver_02.CUSTOM_INTENT");
      sendBroadcast(intent);
   }
}
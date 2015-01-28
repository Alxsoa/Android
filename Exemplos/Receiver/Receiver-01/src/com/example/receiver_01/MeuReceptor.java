package com.example.receiver_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MeuReceptor extends BroadcastReceiver 
{

   @Override
   public void onReceive(Context context, Intent intent) 
   {
      Toast.makeText(context, "Intent Recebido", Toast.LENGTH_LONG).show();
   }

}
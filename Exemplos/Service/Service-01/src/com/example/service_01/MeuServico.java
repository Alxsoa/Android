package com.example.service_01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MeuServico extends Service 
{
   @Override
   public IBinder onBind(Intent arg0) 
   {
      return null;
   }

   @Override
   public int onStartCommand(Intent intent, int flags, int startId) 
   {
      Toast.makeText(this, "Servico Iniciado", Toast.LENGTH_LONG).show();
      return START_STICKY;
   }
   
   @Override
   public void onDestroy() 
   {
      super.onDestroy();
      Toast.makeText(this, "Servico Terminado", Toast.LENGTH_LONG).show();
   }
}
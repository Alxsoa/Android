package com.example.notificacao_02;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class MainActivity extends Activity 
{
	
 private static final int MY_NOTIFICATION_ID=1;
 NotificationManager ntmGerencia;
 Notification ntfNotifica;
 private final String strWebSite = "http://www.google.com.br";

 @Override
 protected void onCreate(Bundle savedInstanceState) 
 {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  Button buttonSend = (Button)findViewById(R.id.send);
  buttonSend.setOnClickListener(new OnClickListener()
  {

	   @Override
	   public void onClick(View arg0) 
	   {
		   	Context ctxContexto;
		    Intent 	intAcao;
		    PendingIntent pndPendente;
		    
		    ctxContexto = getApplicationContext(); 
		    intAcao 	= new Intent(Intent.ACTION_VIEW, Uri.parse(strWebSite));
		    pndPendente = PendingIntent.getActivity ( MainActivity.this, 
												      0, 
												      intAcao, 
												      Intent.FLAG_ACTIVITY_NEW_TASK ); 		    
		    
		    ntfNotifica = new Notification.Builder(ctxContexto)
					          .setContentTitle("Exercicio de Notificação")
					          .setContentText("http://www.google.com.br")
					          .setTicker("Uma Notificação Chegou para Voce")
					          .setWhen(System.currentTimeMillis())
					          .setContentIntent(pndPendente)
					          .setDefaults(Notification.DEFAULT_ALL)
// 							  .setDefaults(Notification.DEFAULT_SOUND) = Apenas Som
// 							  .setDefaults(Notification.DEFAULT_VIBRATE) = Apenas Vibrate
// 							  .setDefaults(Notification.DEFAULT_ALL) = Som & Vibrate 			          
					          .setAutoCancel(true)
					          .setSmallIcon(R.drawable.ic_launcher)
					          .build();
	    
		    ntmGerencia = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		    ntmGerencia.notify(MY_NOTIFICATION_ID, ntfNotifica);
	
	   	}
  	});
 }
}
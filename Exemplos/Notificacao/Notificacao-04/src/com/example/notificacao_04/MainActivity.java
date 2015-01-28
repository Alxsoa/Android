package com.example.notificacao_04;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint("NewApi")
public class MainActivity extends Activity 
{

// ====================================================================
// Definicoes Gerais de Variaveis
// ====================================================================
	
 int iNotificacao = 0; 
 NotificationManager ntmGerencia;
 Notification ntfNotifica;
 
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
		   criarNotificacao ( "Exercício de Notificação", "Uma Notificação Chegou para Voce", 1 );
		   //ntmGerencia.cancel(1);
	   }
  	});
  
 }
 
 protected void criarNotificacao	( 
		 							  String strTitulo,
		 							  String strNotificacao,
		 							  int iNotificacaoID
		 							) 
 {
	 Context 	ctxContexto;
	 Intent 	intAcao;
	 PendingIntent pndPendente;
	 
	 ctxContexto = getApplicationContext();
	 intAcao 	= new Intent(MainActivity.this, MainActivity.class);	
	 pndPendente = PendingIntent.getActivity (
											      MainActivity.this, 
											      0, 
											      intAcao, 
											      Intent.FLAG_ACTIVITY_NEW_TASK
											 );
		    
	 ntfNotifica = new Notification.Builder(ctxContexto)
     				   .setContentTitle( strTitulo )
				       .setTicker( strNotificacao )
				       .setWhen(System.currentTimeMillis())
				       .setContentIntent(pndPendente)
				       .setDefaults(Notification.DEFAULT_ALL)
				       .setAutoCancel(true)
				       .setSmallIcon(R.drawable.ic_launcher)
				       .build();
	 
	 ntmGerencia = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
	 ntmGerencia.notify(iNotificacaoID, ntfNotifica);
 }
}
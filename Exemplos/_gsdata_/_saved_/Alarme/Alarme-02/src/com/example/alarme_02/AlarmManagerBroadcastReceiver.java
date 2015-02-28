package com.example.alarme_02;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.widget.Toast;

@SuppressLint({ "SimpleDateFormat", "Wakelock" })
public class AlarmManagerBroadcastReceiver extends BroadcastReceiver 
{

	final public static String NOME_TIMER = "MeuTimer";
	@Override
	public void onReceive(Context ctxContexto, Intent intent) 
	{
		 PowerManager pwmBateria = (PowerManager) ctxContexto.getSystemService(Context.POWER_SERVICE);
         PowerManager.WakeLock pwmAcorda = pwmBateria.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MINHA TAG");
         pwmAcorda.acquire();

         Bundle bndExtras = intent.getExtras();
         StringBuilder msgStr = new StringBuilder();
         
         if(bndExtras != null && bndExtras.getBoolean(NOME_TIMER, Boolean.FALSE))
         {
        	 msgStr.append("Recebido Evento do Timer =  ");
         }
         Format fmtFormato = new SimpleDateFormat("hh:mm:ss a");
         msgStr.append(fmtFormato.format(new Date()));

         Toast.makeText(ctxContexto, msgStr, Toast.LENGTH_LONG).show();
         pwmAcorda.release();         
	}
	
    public void DefineSingleTimer (Context context)
    {
    	AlarmManager almAlarme=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intAlarme = new Intent(context, AlarmManagerBroadcastReceiver.class);
        intAlarme.putExtra(NOME_TIMER, Boolean.TRUE);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, intAlarme, 0);
        almAlarme.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pi);
    }
}

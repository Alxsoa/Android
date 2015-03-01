package com.example.alarme_03;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.widget.Toast;

@SuppressLint({ "SimpleDateFormat", "Wakelock" })
public class AlarmManagerBroadcastReceiver extends BroadcastReceiver 
{

	final public static String NOME_TIMER = "MeuTimer";
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		 PowerManager pwmBateria = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
         PowerManager.WakeLock pwmAcorda = pwmBateria.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MINHA TAG");
         pwmAcorda.acquire();

         StringBuilder strMsg = new StringBuilder();       
         Format fmtFormato = new SimpleDateFormat("hh:mm:ss a");
         strMsg.append(fmtFormato.format(new Date()));

         Toast.makeText(context, strMsg, Toast.LENGTH_LONG).show();
         pwmAcorda.release();         
	}	
	public void DefineAlarme (Context context)
    {
        AlarmManager alrMeuAlarme = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent itnAplicacao = new Intent(context, AlarmManagerBroadcastReceiver.class);
        itnAplicacao.putExtra(NOME_TIMER, Boolean.FALSE);
        PendingIntent pndBroadCast = PendingIntent.getBroadcast(context, 0, itnAplicacao, 0);
        alrMeuAlarme.setRepeating (AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 5 , pndBroadCast); 
    }
    public void CancelaAlarme (Context context)
    {
        Intent itnAplicacao = new Intent(context, AlarmManagerBroadcastReceiver.class);
        PendingIntent pndSender = PendingIntent.getBroadcast(context, 0, itnAplicacao, 0);
        AlarmManager almManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        almManager.cancel(pndSender);
    }
}

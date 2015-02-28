package com.example.alarme_01;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;

public class AlarmManagerActivity extends Activity 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);       
    }
       
    public void MeuTimer (View view)
    {
        Intent intNovoAlarmer = new Intent(AlarmClock.ACTION_SET_ALARM);
        final Calendar cldCalendario = Calendar.getInstance();
        
        int iHora = cldCalendario.get(Calendar.HOUR_OF_DAY);
        int iMinuto = cldCalendario.get(Calendar.MINUTE);
                
        intNovoAlarmer.putExtra(AlarmClock.EXTRA_HOUR, iHora);
        intNovoAlarmer.putExtra(AlarmClock.EXTRA_MINUTES, iMinuto+1);
        startActivity(intNovoAlarmer);
    }   
}


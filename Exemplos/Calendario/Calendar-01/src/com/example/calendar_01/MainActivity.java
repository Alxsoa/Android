package com.example.calendar_01;

import java.util.Calendar;

import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

@SuppressLint("NewApi")
public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
	}
	
	public void CriaMeuEvento (View view) 
	{
		Calendar calTempoInicial = Calendar.getInstance();		
		Calendar calTempoFinal	 = Calendar.getInstance();
		
		calTempoInicial.set	( 2013, 7, 19, 7, 30);
		calTempoFinal.set	( 2013, 7, 19, 8, 30);
		
//		intent.putExtra (	Events.RRULE,
//							"FREQ=WEEKLY;COUNT=11;WKST=SU;BYDAY=TU,TH");
		
		
		Intent intent = new Intent(Intent.ACTION_INSERT)
					    .setData(Events.CONTENT_URI)
					    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, calTempoInicial.getTimeInMillis())
					    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, calTempoFinal.getTimeInMillis())
					    .putExtra(Events.TITLE, "Um Titulo" )
					    .putExtra(Events.DESCRIPTION, "Uma Descrição" )
					    .putExtra(Events.EVENT_LOCATION, "Uma Localização" )
					    .putExtra(Events.ALL_DAY, true )
					    .putExtra(Events.ALLOWED_REMINDERS, "METHOD_ALARM")
					    .putExtra(Intent.EXTRA_EMAIL, "alexandre.soares@yahoo.com,alexandre.asoares@icloud.com");
		startActivity(intent);
	}
}

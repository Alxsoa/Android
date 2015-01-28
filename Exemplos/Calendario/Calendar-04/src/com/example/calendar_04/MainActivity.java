package com.example.calendar_04;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.util.Log;

// Lista Eventos

public class MainActivity extends Activity 
{	 
 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		
	    ArrayList<Long> 	eventID 		= new ArrayList<Long>();
	    ArrayList<String> 	nameOfEvent 	= new ArrayList<String>();
	    ArrayList<String> 	startDates 		= new ArrayList<String>();
	    ArrayList<String> 	endDates 		= new ArrayList<String>();
	    ArrayList<String> 	descriptions 	= new ArrayList<String>();
	    ArrayList<String> 	location 		= new ArrayList<String>();
		
		String TAG = "MeuLog";
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    Cursor cursor = null;
        cursor = getContentResolver()
                .query(Uri.parse("content://com.android.calendar/events"),
                        new String[] { "calendar_id", "title", "description",
                                "dtstart", "dtend", "eventLocation", "_id" }, null,
                        null, null);

        cursor.moveToFirst();
        String CNames[] = new String[cursor.getCount()];

        // fetching calendars id
        nameOfEvent.clear();
        startDates.clear();
        endDates.clear();
        descriptions.clear();
        location.clear();
        
        for (int i = 0; i < CNames.length; i++) 
        {

            //eventID.add(cursor.getLong(0));
            //nameOfEvent.add(cursor.getString(1));
            Log.v( TAG, "ID do Evento   = "+cursor.getString(6));  
  		  	Log.v( TAG, "Nome do Evento = "+cursor.getString(1));  
            
  		  	/*
            if (cursor.getString(2) != null) 
            {
            	Log.v( TAG, "Descricao do Evento = "+cursor.getString(2));  
                //descriptions.add(cursor.getString(2));
            } 
            else 
            {
                descriptions.add("");
            }

            if (cursor.getString(5) != null) 
            {
                location.add(cursor.getString(5));
            } 
            else 
            {
                location.add("");
            }

            CNames[i] = cursor.getString(1);  */
            cursor.moveToNext();

        }

	}
}

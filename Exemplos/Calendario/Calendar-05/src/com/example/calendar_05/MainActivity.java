package com.example.calendar_05;

// Remove Eventos do calendario
// "Teste do Alexandre"

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.ContentUris;
import android.database.Cursor;
import android.util.Log;

public class MainActivity extends Activity 
{	 
 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{

		String TAG = "MeuLog";
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    Cursor cursor = null;
        cursor = getContentResolver()
                .query( Uri.parse("content://com.android.calendar/events"),
                        new String[] { 	"calendar_id", 
                						"title", 
                						"description",
                						"dtstart", 
                						"dtend", 
                						"eventLocation", 
                						"_id" }, 
                		null,
                        null, 
                        null);

        cursor.moveToFirst();
        String CNames[] = new String[cursor.getCount()];
        
        for (int i = 0; i < CNames.length; i++) 
        {
            Uri deleteUri = null;

            Log.v( TAG, "ID do Evento   = "+cursor.getString(6));  
  		  	Log.v( TAG, "Nome do Evento = "+cursor.getString(1));  
            
            long leventID = Long.parseLong(cursor.getString(6));
            if (cursor.getString(1).equals("Teste do Alexandre"))
            {
            	deleteUri = ContentUris.withAppendedId(Events.CONTENT_URI, leventID);       
            	int rows = getContentResolver().delete(deleteUri, null, null);
            }
            
            cursor.moveToNext();
        }

	}
}

package com.example.calendar_03;

// Insere um evento no calend‡rio

import java.util.Calendar;
import java.util.TimeZone;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Calendars;
import android.provider.CalendarContract.Events;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

public class MainActivity extends Activity 
{	 
	// Projection array. Creating indices for this array instead of doing
	 // dynamic lookups improves performance.
	 public static final String[] EVENT_PROJECTION = 
			 new String[] {
						     Calendars._ID,                           // 0
						     Calendars.ACCOUNT_NAME,                  // 1
						     Calendars.CALENDAR_DISPLAY_NAME,         // 2
						     Calendars.OWNER_ACCOUNT                  // 3
	 					   };
	 
	 // The indices for the projection array above.
	 private static final int PROJECTION_ID_INDEX = 0;
	 private static final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
	 private static final int PROJECTION_DISPLAY_NAME_INDEX = 2;
	 private static final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;	
	 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		String TAG = "MeuLog";
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
// Pegando o owner do celular
	    
	    AccountManager accountManager = AccountManager.get(getBaseContext()); 
	    Account[] accounts = accountManager.getAccountsByType("com.google");
	    Account account;
	    if (accounts.length > 0) 
	    {
	      account = accounts[0];   
		  Log.v( TAG, "Account  = "+accounts[0]);  
	    } 
	    else 
	    {
	      account = null;
		  Log.v( TAG, "Nao tem account");
	    }
	    
	 // Run query
	    Cursor cur = null;
	    ContentResolver cr = getContentResolver();
	    Uri uri = CalendarContract.Calendars.CONTENT_URI;   
	    String selection = "((" + Calendars.ACCOUNT_NAME + " = ?) AND (" 
	                            + Calendars.ACCOUNT_TYPE + " = ?) AND ("
	                            + Calendars.OWNER_ACCOUNT + " = ?))";
	    String[] selectionArgs = 
	    		new String[] {
	    						"android.asoares@gmail.com", 
	    						"com.google",
	    						"android.asoares@gmail.com"}; 
	    
	    // Submit the query and get a Cursor object back. 
	    cur = cr.query(uri, EVENT_PROJECTION, selection, selectionArgs, null);
        
	    int iAux = cur.getCount();
	    Log.v( TAG, "Numero de calendarios = "+iAux);
        
	 // Use the cursor to step through the returned records
	    while (cur.moveToNext()) 
	    {
	        long calID = 0;
	        String displayName = null;
	        String accountName = null;
	        String ownerName = null;
	          
	        // Get the field values
	        calID = cur.getLong(PROJECTION_ID_INDEX);
	        displayName = cur.getString(PROJECTION_DISPLAY_NAME_INDEX);
	        accountName = cur.getString(PROJECTION_ACCOUNT_NAME_INDEX);
	        ownerName = cur.getString(PROJECTION_OWNER_ACCOUNT_INDEX);
	        
	                  
	        Log.v( TAG, "Calender ID  = "+calID);
	        Log.v( TAG, "Display Name = "+displayName);
	        Log.v( TAG, "Account Name = "+accountName);
	        Log.v( TAG, "Owner Name   = "+ownerName);
	        
	        // Adicionando um Evento
	        long startMillis = 0; 
	        long endMillis = 0;     
	        Calendar beginTime = Calendar.getInstance();
	        String tz = TimeZone.getDefault().getID();
	        Log.v( TAG, "Time Zone  = "+tz);
	        
	        beginTime.set(2013, 7, 11, 12, 30);
	        startMillis = beginTime.getTimeInMillis();
	        Calendar endTime = Calendar.getInstance();
	        endTime.set(2013, 7, 11, 14, 45);
	        endMillis = endTime.getTimeInMillis();
	
	        cr = getContentResolver();
	        ContentValues values = new ContentValues();
	        values.put(Events.DTSTART, startMillis);
	        values.put(Events.DTEND, endMillis);
	        values.put(Events.TITLE, "Teste do Alexandre");
	        values.put(Events.DESCRIPTION, "Atividades de Teste");
	        values.put(Events.CALENDAR_ID, calID);
	        //values.put(Events.EVENT_TIMEZONE, "America/Los_Angeles");
	        
	        values.put(Events.EVENT_TIMEZONE, tz);
	        uri = cr.insert(Events.CONTENT_URI, values);

	        // get the event ID that is the last element in the Uri
	        long eventID = Long.parseLong(uri.getLastPathSegment());
	        // 
	        // ... do something with event ID
	        //
	        //	        
	        
	    } 


	}
}

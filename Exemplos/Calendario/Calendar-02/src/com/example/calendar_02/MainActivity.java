package com.example.calendar_02;

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
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity 
{	 

	 public static final String[] EVENT_PROJECTION = new String[] 
			 										 {
													     Calendars._ID,                           // 0
													     Calendars.ACCOUNT_NAME,                  // 1
													     Calendars.CALENDAR_DISPLAY_NAME,         // 2
													     Calendars.OWNER_ACCOUNT                  // 3
			 										 };
	 
	 private static final int PROJECTION_ID_INDEX = 0;
	 private static final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
	 private static final int PROJECTION_DISPLAY_NAME_INDEX = 2;
	 private static final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;	
	 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		String TAG = "MeuLog";
		AccountManager 	acmAccount;
		Account 		accAcount;
		Account[] 		lstAccount;        
		Calendar 		calBeginTime;
        Calendar 		calEndTime;
        String 			strTimeZone;
        ContentResolver cnrConteudo;
        Uri				uriCalendar;
        Time 			timHoje;
		Cursor 			curPonteiro 		= null;
		int 			iAux				= 0;
        long 			lCalendarID			= 0;
        String 			strDisplayName 		= null;
        String 			strAccountName 		= null;
        String 			strOwnerName 		= null;
        long 			lStartMilis 		= 0; 
        long 			lEndMilis 			= 0;  
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
//	===================================================================    
// 	Recupera o Owner do Dispositivo
//	===================================================================  
	    
	    acmAccount = AccountManager.get(getBaseContext()); 
	    lstAccount = acmAccount.getAccountsByType("com.google");	    
	    
	    if (lstAccount.length > 0) 
	    {
	      accAcount = lstAccount[0];   
		  Log.v( TAG, "Account  = "+lstAccount[0]);  
	    } 
	    else 
	    {
	      accAcount = null;
		  Log.v( TAG, "Nao tem account");
	    }
	    
//	===================================================================  
// 	Encaminha ao Dispositivo a Query de Propriedade e Calendario 
//	===================================================================   
  
	    String selection = "((" + Calendars.ACCOUNT_NAME + " = ?) AND (" 
	                            + Calendars.ACCOUNT_TYPE + " = ?) AND ("
	                            + Calendars.OWNER_ACCOUNT + " = ?))";
	    
	    cnrConteudo = getContentResolver();
	    uriCalendar = CalendarContract.Calendars.CONTENT_URI; 	    
	    String[] strArgumentos = new String[3]; 

	    strArgumentos[0] = accAcount.name.toString();
	    strArgumentos[1] = "com.google".toString();
	    strArgumentos[2] = accAcount.name.toString();
	    
	    Log.v( TAG, "accounts[0] 		= "+accAcount.name);
	    Log.v( TAG, "selectionArgs [0] 	= "+strArgumentos [0]);
	    Log.v( TAG, "selectionArgs [1] 	= "+strArgumentos [1]);
	    Log.v( TAG, "selectionArgs [2] 	= "+strArgumentos [2]);
	    
//	===================================================================  
// 	Envia a Query e Recupera o Cursor 
//	=================================================================== 
	  
	    curPonteiro = cnrConteudo.query ( 	uriCalendar, 
	    									EVENT_PROJECTION, 
	    									selection, 
	    									strArgumentos, 
	    									null );
        iAux = curPonteiro.getCount();
	    Log.v( TAG, "Numero de calendarios = "+iAux);
        
//	===================================================================  
// 	Navega a partir do Cursor Retornando os Registros
//	=================================================================== 

	    while (curPonteiro.moveToNext()) 
	    {
	    	lCalendarID		= 0;
	        strDisplayName 	= null;
	        strAccountName 	= null;
	        strOwnerName 	= null;
	          
//	===================================================================  
//	Pega os Dados Referente a Query Realizada
//	=================================================================== 
	        
	        lCalendarID	   = curPonteiro.getLong (PROJECTION_ID_INDEX);
	        strDisplayName = curPonteiro.getString (PROJECTION_DISPLAY_NAME_INDEX);
	        strAccountName = curPonteiro.getString (PROJECTION_ACCOUNT_NAME_INDEX);
	        strOwnerName   = curPonteiro.getString (PROJECTION_OWNER_ACCOUNT_INDEX);	        
	                  
	        Log.v( TAG, "Calender ID  = "+lCalendarID);
	        Log.v( TAG, "Display Name = "+strDisplayName);
	        Log.v( TAG, "Account Name = "+strAccountName);
	        Log.v( TAG, "Owner Name   = "+strOwnerName);
	        
//	===================================================================  
//	Identifica a Zona de Tempo Atual
//	=================================================================== 
   	        
	        strTimeZone = TimeZone.getDefault().getID();
	        Log.v( TAG, "Time Zone  = "+strTimeZone);
	       
//	===================================================================  
//	Pega a Data Corrente
//	=================================================================== 	        
	        
	        timHoje = new Time(Time.getCurrentTimezone());
	        timHoje.setToNow();
	        
	        calBeginTime = Calendar.getInstance();
	        calBeginTime.set(timHoje.year, timHoje.month, timHoje.monthDay, 12, 30);
	        lStartMilis  = calBeginTime.getTimeInMillis();
	        
	        calEndTime   = Calendar.getInstance();
	        calEndTime.set(timHoje.year, timHoje.month, timHoje.monthDay, 14, 45);
	        lEndMilis    = calEndTime.getTimeInMillis();

//	===================================================================  
//	Adiciona um Registro no Calendario
//	=================================================================== 
	        
	        cnrConteudo = getContentResolver();
	        ContentValues values = new ContentValues();
	        values.put ( Events.DTSTART, lStartMilis );
	        values.put ( Events.DTEND, lEndMilis );
	        values.put ( Events.TITLE, "Teste do Alexandre" );
	        values.put ( Events.DESCRIPTION, "Atividades de Teste" );
	        values.put ( Events.CALENDAR_ID, lCalendarID );       
	        values.put ( Events.EVENT_TIMEZONE, strTimeZone );
	        uriCalendar = cnrConteudo.insert(Events.CONTENT_URI, values );
     
	        Toast.makeText(getApplicationContext(), "Evento no Calend‡rio Criado", Toast.LENGTH_SHORT).show();

	    } 
	}
}

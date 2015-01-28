package com.example.telefone_04;


import java.util.Date;  
import android.app.Activity; 
import android.database.Cursor; 
import android.os.Bundle; 
import android.provider.CallLog; 
import android.widget.TextView; 

public class MainActivity extends Activity 
{

    private static final int MISSED_CALL_TYPE = 0;
    private TextView txtcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtcall = (TextView) findViewById(R.id.textview_call);
        StringBuffer sb = new StringBuffer();
        Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null,null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        sb.append("Call Details :");
        while (managedCursor.moveToNext()) 
        {
            String phNumber = managedCursor.getString(number);
            String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = managedCursor.getString(duration);
            String dir = null;
            int dircode = Integer.parseInt(callType);
            switch (dircode) 
            {
	            case CallLog.Calls.OUTGOING_TYPE:
	                dir = "SAINTE";
	                break;
	
	            case CallLog.Calls.INCOMING_TYPE:
	                dir = "ENTRANTE";
	                break;
	
	            case CallLog.Calls.MISSED_TYPE:
	                dir = "PERDIDA";
	                break;
            }
            
            sb.append("\nNœmero Telefone:--- " + phNumber + " \nTipo de Chamada:--- "
                    + dir + " \nData de Chamada:--- " + callDayTime
                    + " \nDuracao em Seg :--- " + callDuration);
            sb.append("\n----------------------------------");
            
        }
        managedCursor.close();
        txtcall.setText(sb);
    }
} 


package com.example.telefone_05;

import android.app.Activity;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
 
public class MainActivity extends Activity 
{
 
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        Button addButton = (Button) findViewById(R.id.button1);
        addButton.setOnClickListener(new OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
                  long  callTimeInMiliSecond = System.currentTimeMillis(); 
                  CallLogActivity utility = new CallLogActivity(); 
                  String numberStr = "+5521994911320";
                  utility.AddNumToCallLog (	getBaseContext().getContentResolver(),
                		  					numberStr, 
                		  					CallLog.Calls.OUTGOING_TYPE, 
                		  					callTimeInMiliSecond );
            }
        });
         
        Button deleteButton = (Button) findViewById(R.id.button2);
        deleteButton.setOnClickListener(new OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
                String numberStr = "+5521994911320"; 
                CallLogActivity utility = new CallLogActivity(); 
                utility.DeleteNumFromCallLog ( getBaseContext().getContentResolver(), 
                						   	   numberStr);
            }
        });
    }
}

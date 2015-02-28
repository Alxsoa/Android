package com.example.alarme_02;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class AlarmManagerActivity extends Activity 
{

	private AlarmManagerBroadcastReceiver alrRecebedor;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alrRecebedor = new AlarmManagerBroadcastReceiver();
        
    }
       
    public void MeuTimer (View view)
    {
    	Context ctxContexto = this.getApplicationContext();
    	if(alrRecebedor != null)
    	{
    		alrRecebedor.DefineSingleTimer (ctxContexto);
    	}
    }
    
}

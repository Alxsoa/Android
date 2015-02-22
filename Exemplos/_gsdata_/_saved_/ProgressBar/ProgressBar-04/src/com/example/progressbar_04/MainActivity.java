package com.example.progressbar_04;

import android.app.Activity;
import android.app.Dialog;
import android.os.Message;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity 
{      
    ProgressThread progThread;
    ProgressDialog progDialog;
    Button btnBotao01, btnBotao02;
    int iTipoBarra;                     
    int iEspera = 40;                  
    int iValorMax = 200;           
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnBotao02 = (Button) findViewById(R.id.idBotao02);
        btnBotao02.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v) 
            {
                iTipoBarra = 1;
                showDialog(iTipoBarra);
            }
        }); 
    }
    
    @Override
    protected Dialog onCreateDialog(int id) 
    {           
        progDialog = new ProgressDialog(this);
        progDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progDialog.setMax(iValorMax);
        progDialog.setMessage("Perda de Press‹o");
        progThread = new ProgressThread(handler);
        progThread.start();
        return progDialog;
    }
    
    final Handler handler = new Handler() 
    {
        public void handleMessage(Message msg) 
        {
            int total = msg.getData().getInt("total");
            progDialog.setProgress(total);
            if (total <= 0)
            {
                dismissDialog(iTipoBarra);
                progThread.setState(ProgressThread.DONE);
            }
        }
    };
    
    private class ProgressThread extends Thread 
    {	
        final static int DONE = 0;
        final static int RUNNING = 1;
        
        Handler mHandler;
        int mState;
        int total;
        
        ProgressThread(Handler h) 
        {
            mHandler = h;
        }
        
        @Override
        public void run() 
        {
            mState = RUNNING;   
            total = iValorMax;
            while (mState == RUNNING) 
            {
                try 
                {
                    Thread.sleep(iEspera);
                } 
                catch (InterruptedException e) 
                {
                    Log.e("ERROR", "Thread was Interrupted");
                }
                 
                Message msg = mHandler.obtainMessage();
                Bundle b = new Bundle();
                b.putInt("total", total);
                msg.setData(b);
                mHandler.sendMessage(msg);
                
                total--;    
            }
        }
        
        public void setState(int state) 
        {
            mState = state;
        }
    }
}

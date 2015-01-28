package com.example.alxsoa.thread_01;

//
// http://www.edumobile.org/android/android-development/timer-thread-example-in-android-programming/
//

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{
    protected int iTempoSplash = 3000;
    TextView lblMsg;
    String[] strSoletra = {"A","N","D","R","O","I","D"};
    int iTempo = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblMsg = (TextView) findViewById(R.id.IdlblMsg);
        Thread thrSoletra=new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    for (iTempo = 0; iTempo < strSoletra.length; iTempo++)
                    {
                        int iEspera = 0;
                        while(iEspera < iTempoSplash)
                        {
                            Thread.sleep(100);
                            runOnUiThread(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    try
                                    {
                                        lblMsg.setText(strSoletra[iTempo]);
                                    }
                                    catch(Exception e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            iEspera += 100;
                        }
                    }
                }
                catch (InterruptedException e)
                {
                }
            }
        };
        thrSoletra.start();
    }
}
package com.example.alxsoa.thread_03;

//
// http://www.edumobile.org/android/android-development/timer-thread-example-in-android-programming/
//

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{
    protected int iTempoSplash = 20000;
    TextView lblMsg1;
    TextView lblMsg2;

    Thread thrTexto1;
    Thread thrTexto2;

    int iTempo1;
    int iTempo2;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblMsg1 = (TextView) findViewById(R.id.IdlblMsg1);
        lblMsg2 = (TextView) findViewById(R.id.IdlblMsg2);

        thrTexto1 = new Thread(new MyTask1());
        thrTexto1.start();

        thrTexto2 = new Thread(new MyTask2());
        thrTexto2.start();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        thrTexto1.interrupt();
        thrTexto2.interrupt();
    }

    public class MyTask1 implements Runnable
    {
        public void run ()
        {
            try
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
                                lblMsg1.setText(String.valueOf(iTempo1));
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    });
                    iEspera += 50;
                    iTempo1++;
                }
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    public class MyTask2 implements Runnable
    {
        public void run ()
        {
            try
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
                                lblMsg2.setText(String.valueOf(iTempo2));
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    });
                    iEspera += 50;
                    iTempo2++;
                }
            }
            catch (InterruptedException e)
            {
            }
        }
    }

}


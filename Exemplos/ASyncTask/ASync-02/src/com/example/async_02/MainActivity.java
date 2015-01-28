package com.example.async_02;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
 
public class MainActivity extends Activity 
{
 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Processo processo = new Processo(this);
        processo.execute(1000, 2000, 3000, 4000);
    }
 
    public class Processo extends AsyncTask<Integer, String, Integer> 
    {
        private ProgressDialog progress;
        private Context context;
 
        public Processo(Context context) 
        {
            this.context = context;
        }
 
        @Override
        protected void onPreExecute() 
        {
            progress = new ProgressDialog(context);
            progress.setMessage("Processando ...");
            progress.show();
        }
 
        @Override
        protected Integer doInBackground(Integer... paramss) 
        {
            for (int i = 0; i < paramss.length; i++) 
            {
                try 
                {
                    Thread.sleep(paramss[i]);
                    publishProgress(i + "...");
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
            return 1;
        }
 
        @Override
        protected void onPostExecute(Integer result) 
        {
            progress.dismiss();
        }
 
        @Override
        protected void onProgressUpdate(String... values) 
        {
            progress.setMessage(values[0]);
        }
    }
}
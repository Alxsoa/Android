package com.example.seekbar_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        SeekBar sekBarra = (SeekBar)findViewById(R.id.seekBar1);
        final TextView txtValor=(TextView)findViewById(R.id.textView1);
        txtValor.setText("O Valor Atual é : 50");
       
        sekBarra.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
        {
                    
	         public void onStopTrackingTouch(SeekBar arg0) 
	         {                   
	         }
	        
	         public void onStartTrackingTouch(SeekBar arg0) 
	         {
	         }
	        
	         public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) 
	         {
	        	 txtValor.setText("O Valor Atual é : "+ arg1);
	         }
        });       
    }
}
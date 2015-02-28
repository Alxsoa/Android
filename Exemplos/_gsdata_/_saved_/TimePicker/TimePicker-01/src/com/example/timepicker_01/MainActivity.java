package com.example.timepicker_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity 
{  
    TimePicker timepicker;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        timepicker = (TimePicker) findViewById(R.id.timePicker);
        timepicker.setIs24HourView(true);
        
       Button button = (Button) findViewById(R.id.btn);
       button.setOnClickListener(new View.OnClickListener() 
       {        
        @Override
        public void onClick(View v) 
        {      
        	Toast.makeText ( getBaseContext(),"Tempo Selecionado : " 
        					 +timepicker.getCurrentHour()
        					 +":"
        					 +timepicker.getCurrentMinute(), Toast.LENGTH_SHORT).show();
        }
       });
    }
}


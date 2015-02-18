package com.example.toast_06;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class CustomToastExActivity extends Activity 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void getCustomToast(View view)
    {
    	LayoutInflater inflator=getLayoutInflater();
    	View layout=inflator.inflate(R.layout.layout_toast,(ViewGroup)findViewById(R.id.custom_toast_id));
    	Toast toast=new Toast(getApplicationContext());
    	toast.setGravity(Gravity.TOP, 0, 500);
    	toast.setDuration(Toast.LENGTH_LONG);
    	toast.setView(layout);
    	toast.show();  	
    }
}
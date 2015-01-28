package com.example.viewflipper_01;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;
 
public class MainActivity extends Activity 
{
 
	ViewFlipper vwfFlipper;
	Button btnProximo, btnAnterior;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    
        vwfFlipper  = (ViewFlipper) findViewById(R.id.idViewFlipper);        

        btnProximo  = (Button) findViewById(R.id.idProximo);        
        btnProximo.setOnClickListener(new View.OnClickListener() 
        {	
			public void onClick(View v) 
			{
				vwfFlipper.showNext();
			}
        });
        
        btnAnterior = (Button) findViewById(R.id.idAnterior);       
        btnAnterior.setOnClickListener(new View.OnClickListener() 
        {
			public void onClick(View v) 
			{
				vwfFlipper.showPrevious();
			}
        });
    }
}
package com.example.viewcode_01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private static final  int COLOR_SELECTOR=0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get the Select Color button
        Button selectColorButton = (Button) findViewById(R.id.selectColor);
        //set action listener for button
        selectColorButton.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				//first create new intent to call ColorSelectorActivity 
				Intent request =new Intent(MainActivity.this, wndSegunda.class);	
				startActivityForResult(request, COLOR_SELECTOR);		
			}
		});
    }
    //this is the method that call when Activity result comes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	//check which activity gives data
    	switch(requestCode){
    	//checking for our ColorSelectorActivity using request code
    	case COLOR_SELECTOR:
    		//check whether result comes with RESULT_OK (That mean no problem in result)
    		if(resultCode == RESULT_OK){
    			//then get the color string that return from our ColorSelectorActivity
    			String color= data.getExtras().getString("selectedColor");
    			//then set background color
    			findViewById(R.id.colorBox).setBackgroundColor(Color.parseColor(color));
    		}
    	}
    }
}
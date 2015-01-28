package com.example.specialbutton_02;


import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
	 switch(keyCode)
	 {     
	   case  KeyEvent.KEYCODE_VOLUME_UP:
			 Toast.makeText(this, "Volume UP Pressionado", Toast.LENGTH_SHORT).show();
		     return true;
		     
	   case  KeyEvent.KEYCODE_VOLUME_DOWN:
		     Toast.makeText(this,"Volume Down Pressionado", Toast.LENGTH_SHORT).show();
		     return false;
	 }
	 return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) 
	{
	 switch(keyCode)
	 {     
	   case  KeyEvent.KEYCODE_VOLUME_UP:
			 Toast.makeText(this, "Volume UP Largado", Toast.LENGTH_SHORT).show();
		     return true;
		     
	   case  KeyEvent.KEYCODE_VOLUME_DOWN:
		     Toast.makeText(this,"Volume Down Largado", Toast.LENGTH_SHORT).show();
		     return false;
	 }
	 return super.onKeyDown(keyCode, event);
	}
}

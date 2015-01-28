package com.example.menu_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
 
public class MainActivity extends Activity 
{

	public static final int MENU1 = 0;
	public static final int MENU2 = 1;
	public static final int MENU3 = 2;
 
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
 
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		menu.add(0, MENU1, 0, "Menu1");
		menu.add(0, MENU2, 0, "Menu2");		
		menu.add(0, MENU3, 0, "Menu3");	
		
		return super.onCreateOptionsMenu(menu);	 
	}
 
	public boolean onOptionsItemSelected(MenuItem item) 
	{
	 
		switch (item.getItemId()) 
		{
			case MENU1:
				Toast.makeText(	MainActivity.this, 
								"Menu1 Selecionado", 
								Toast.LENGTH_SHORT).show();
				return true;
			 
			case MENU2:
				Toast.makeText(	MainActivity.this, 
								"Menu2 Selecionado",
								Toast.LENGTH_SHORT).show();
				return true;
		}
 
	return false;
	}
}
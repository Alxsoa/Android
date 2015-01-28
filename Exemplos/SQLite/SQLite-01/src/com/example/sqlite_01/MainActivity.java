package com.example.sqlite_01;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		String TAG = "SQLite";
		DBController dbcController = new DBController(this);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbcController.addProduto("Banana", "123");
	}
}
package com.example.ciclovida_02;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("MeuLog", PegaNomeClasse()+".onCreate();");
	}
	
	public void onStart()
	{
		super.onStart();
		Log.v("MeuLog", PegaNomeClasse()+".onStart();");
	}
	
	public void onRestart()
	{
		super.onRestart();
		Log.v("MeuLog", PegaNomeClasse()+".onRestart();");
	}
	
	public void onResume()
	{
		super.onResume();
		Log.v("MeuLog", PegaNomeClasse()+".onResume();");
	}
	
	public void onPause()
	{
		super.onPause();
		Log.v("MeuLog", PegaNomeClasse()+".onPause();");
	}
	
	public void onStop()
	{
		super.onStop();
		Log.v("MeuLog", PegaNomeClasse()+".onStop();");
	}
	
	public void onDestroy()
	{
		super.onDestroy();
		Log.v("MeuLog", PegaNomeClasse()+".onDestroy();");
	}	
	
	private String PegaNomeClasse()
	{
		String strNome = getClass().getName();
		return(strNome.substring(strNome.lastIndexOf(".") +1));
	}
	
	public void AtivaActivity(View view)
	{
		Intent intent = new Intent(this, NovaAtividade.class);
		startActivity(intent);
	}
}

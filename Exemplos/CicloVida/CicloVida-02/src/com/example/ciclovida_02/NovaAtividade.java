package com.example.ciclovida_02;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;

public class NovaAtividade extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nova_atividade);			
		Log.v("MeuLog", PegaNomeClasse()+".onCreate();");
	}
	
	protected void onStart()
	{
		super.onStart();
		Log.v("MeuLog", PegaNomeClasse()+".onStart();");
	}
	
	protected void onRestart()
	{
		super.onRestart();
		Log.v("MeuLog", PegaNomeClasse()+".onRestart();");
	}
	
	protected void onResume()
	{
		super.onResume();
		Log.v("MeuLog", PegaNomeClasse()+".onResume();");
	}
	
	protected void onPause()
	{
		super.onPause();
		Log.v("MeuLog", PegaNomeClasse()+".onPause();");
	}
	
	protected void onStop()
	{
		super.onStop();
		Log.v("MeuLog", PegaNomeClasse()+".onStop();");
	}
	
	protected void onDestroy()
	{
		super.onDestroy();
		Log.v("MeuLog", PegaNomeClasse()+".onDestroy();");
	}

	private String PegaNomeClasse()
	{
		String strNome = getClass().getName();
		return(strNome.substring(strNome.lastIndexOf(".") +1));
	}
	
	public void voltar(View view)
	{
		finish();
	}
}

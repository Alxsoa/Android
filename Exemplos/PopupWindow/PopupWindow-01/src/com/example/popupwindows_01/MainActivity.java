package com.example.popupwindows_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void MeuPopUpWindow(View view)
	{
		
		switch ( view.getId() )
		{
			case R.id.idImgBlue : 	Janela.MeuPopUpWindow (	view, "Informação Azul foi Pressionada" );
									break;
													
			case R.id.idImgRed 	: 	Janela.MeuPopUpWindow (	view, "Informação Vermelha foi Pressionada" );
									break;
		}
	}
}

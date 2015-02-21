package com.example.checkbox_03;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity 
{

	private CheckBox 	chkIos, 
						chkAndroid, 
						chkWindows;
	private Button 		btnDisplay;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addListenerOnChkIos();
		addListenerOnButton();
	}

	public void addListenerOnChkIos() 
	{
		chkIos 		= (CheckBox) findViewById(R.id.chkIos);
		chkIos.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{

				if (((CheckBox) v).isChecked()) 
				{
					chkAndroid 	= (CheckBox) findViewById(R.id.chkAndroid);
					chkAndroid.setChecked(true);
					
					Toast.makeText ( MainActivity.this,
									 "Camarada Escolhi Android pra Voce", 
									 Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	public void addListenerOnButton() 
	{
		chkIos 		= (CheckBox) findViewById(R.id.chkIos);
		chkAndroid 	= (CheckBox) findViewById(R.id.chkAndroid);
		chkWindows 	= (CheckBox) findViewById(R.id.chkWindows);
		btnDisplay 	= (Button) 	 findViewById(R.id.btnDisplay);

		btnDisplay.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				StringBuffer result = new StringBuffer();
				Boolean bEscolha = false;
				
				if (chkIos.isChecked())
				{
					result.append("IPhone foi Selecionada \n");
					bEscolha = true;
				}

				if (chkAndroid.isChecked())
				{
					result.append("Android foi Selecionada \n");
					bEscolha = true;
				}

				if (chkWindows.isChecked())
				{
					result.append("Windows foi Selecionada \n");
					bEscolha = true;
				}
				
				if ( !bEscolha )
				{
					result.append("\n Nenhuma Opção foi Selecionada \n");	
				}

				Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_LONG).show();
			}
		});
	}
}
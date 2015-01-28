package com.example.specialbutton_01;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class MainActivity extends Activity 
{

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onBackPressed() 
	{
		BotaoBack();
		return;
	}

	public void BotaoBack() 
	{
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
		alertDialog.setTitle("Sair da Aplicação");
		alertDialog.setMessage("Voce Realmente deseja Sair da Aplicação ?");
		alertDialog.setIcon(R.drawable.ic_launcher);
		
		alertDialog.setPositiveButton("Sim",
				new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog, int which) 
					{
						finish();
					}
				});
		
		alertDialog.setNegativeButton("Não",
				new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog, int which) 
					{
						dialog.cancel();
					}
				});

		alertDialog.show();
	}
}

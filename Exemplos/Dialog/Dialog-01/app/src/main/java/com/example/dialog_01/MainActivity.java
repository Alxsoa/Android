package com.example.dialog_01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity 
{
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnAlertaUmBotao = (Button) findViewById(R.id.idBtnAlertaUmBotao);
		btnAlertaUmBotao.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				AlertDialog.Builder alrDialog = new AlertDialog.Builder(MainActivity.this);
				alrDialog.setTitle ("Comunicação ...");
				alrDialog.setMessage ("Bem Vindo ao Android");
				alrDialog.setIcon (R.drawable.tick);
				alrDialog.setPositiveButton("OKay",new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog,int which) 
					{
		                dialog.cancel();
					}
				});
				alrDialog.show();				
			}
		});		
	}
}
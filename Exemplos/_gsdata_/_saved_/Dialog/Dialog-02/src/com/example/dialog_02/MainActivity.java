package com.example.dialog_02;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnAlertaDoisBotao = (Button) findViewById(R.id.idBtnAlertaDoisBotoes);
		btnAlertaDoisBotao.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				AlertDialog.Builder alrDialog = new AlertDialog.Builder(MainActivity.this);
				alrDialog.setTitle ("Confirme a Remo��o ...");
				alrDialog.setMessage ("Voce Confirma a Remo��o Deste Arquivo ?");
				alrDialog.setIcon (R.drawable.delete);
				
				alrDialog.setPositiveButton("Sim",new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog,int which) 
					{
						Toast.makeText(getApplicationContext(), "A Op��o Escolhida foi Sim", Toast.LENGTH_SHORT).show();
					}
				});
				
				alrDialog.setNegativeButton("N�o",new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog,	int which) 
					{
						Toast.makeText(getApplicationContext(), "A Op��o Escolhida foi N�o", Toast.LENGTH_SHORT).show();
						dialog.cancel();
					}
				});
				alrDialog.show();
			}
		});		
	}
}
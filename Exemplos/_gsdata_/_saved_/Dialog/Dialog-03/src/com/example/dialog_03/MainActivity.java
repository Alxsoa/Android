package com.example.dialog_03;

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

		Button btnAlertaTresBotao = (Button) findViewById(R.id.idBtnAlertaTresBotoes);
		btnAlertaTresBotao.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				AlertDialog.Builder alrDialog = new AlertDialog.Builder (MainActivity.this);
				alrDialog.setTitle("Salvando o Arquivo...");
				alrDialog.setMessage("Voce Deseja Salvar Este Arquivo ?");
				alrDialog.setIcon(R.drawable.save);
				alrDialog.setPositiveButton("Sim",new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog, int which) 
					{
						Toast.makeText(getApplicationContext(),"A Opção Escolhida foi Sim",Toast.LENGTH_SHORT).show();
					}
				});
				
				alrDialog.setNeutralButton("Não", new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog, int which) 
					{
						Toast.makeText(getApplicationContext(),"A Opção Escolhida foi Não", Toast.LENGTH_SHORT).show();
					}
				});

				alrDialog.setNegativeButton("Cancela", new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog, int which) 
					{
						Toast.makeText(getApplicationContext(),"A Opção Escolhida foi Cancelamento",Toast.LENGTH_SHORT).show();
					}
				});
				alrDialog.show();
			}
		});
	}
}
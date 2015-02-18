package com.example.dialog_04;

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

		Button btnAlertaUmBotao = (Button) findViewById(R.id.idBtnAlertaUmBotao);
		btnAlertaUmBotao.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				
				final CharSequence[] items = {"Vermelho", "Verde", "Azul"};

				AlertDialog.Builder alrDialog = new AlertDialog.Builder(MainActivity.this);
				alrDialog.setTitle("Escolha uma Cor");
				alrDialog.setItems(items, new DialogInterface.OnClickListener() 
				{
				    public void onClick(DialogInterface dialog, int item) 
				    {
				        Toast.makeText ( getApplicationContext(),"A Cor Escolhida foi "+items[item],Toast.LENGTH_SHORT).show();
				    }
				});
				alrDialog.show();
			
			}
		});		
	}
}
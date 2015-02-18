package com.example.dialog_06;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity
{

	final Context context = this;

	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button BtnAlertaUmBotao = (Button) findViewById(R.id.idBtnAlertaUmBotao);
		BtnAlertaUmBotao.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0) 
			{
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.customizado);
				dialog.setTitle("Meu Titulo");

				TextView TxtMsg = (TextView) dialog.findViewById(R.id.idTxtMsg);
				TxtMsg.setText("Dialogo Customizado");
				
				ImageView ImgIcone = (ImageView) dialog.findViewById(R.id.idImgIcone);
				ImgIcone.setImageResource(R.drawable.ic_launcher);

				Button BtnOkay = (Button) dialog.findViewById(R.id.idBtnOkay);
				BtnOkay.setOnClickListener(new OnClickListener() 
				{
					@Override
					public void onClick(View v) 
					{
						dialog.dismiss();
					}
				});
				dialog.show();
			}
		});
	}
}
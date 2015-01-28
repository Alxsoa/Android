package com.example.popupwindows_01;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Janela 
{
	public static void MeuPopUpWindow (View viwViewLocal, String strMsg )
	{
		final PopupWindow ppwJanela = new PopupWindow(viwViewLocal.getContext());
		
		LayoutInflater inflater 	= (LayoutInflater) viwViewLocal.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		RelativeLayout rltLayout 	= (RelativeLayout) inflater.inflate(R.layout.popup_window, null);
		
		ppwJanela.setContentView(rltLayout);
		ppwJanela.setWidth(LayoutParams.MATCH_PARENT);
		ppwJanela.setHeight(LayoutParams.WRAP_CONTENT);
		ppwJanela.setOutsideTouchable(true);
		ppwJanela.setBackgroundDrawable(viwViewLocal.getContext().getResources().getDrawable(android.R.color.transparent));
		ppwJanela.showAtLocation(viwViewLocal, Gravity.CENTER, 0, 0);
		
		TextView txtInfo = (TextView) rltLayout.findViewById(R.id.idTxtInfo);
		txtInfo.setText(strMsg);
		
		Button BtnOK = (Button) rltLayout.findViewById(R.id.idBtnOK);
		BtnOK.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v) 
			{
				ppwJanela.dismiss();
			}
		});
	}
}

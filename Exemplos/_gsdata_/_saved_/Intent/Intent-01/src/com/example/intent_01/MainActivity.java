package com.example.intent_01;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity 
{ 
	private Button btnDiscar;
 
	public void onCreate(Bundle savedInstanceState) 
	{
 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		btnDiscar = (Button) findViewById(R.id.idBtnDiscar);
		btnDiscar.setOnClickListener(new OnClickListener() 
		{
 
			@Override
			public void onClick(View arg0) 
			{
 				Intent ittDiscar = new Intent(Intent.ACTION_DIAL);
 				ittDiscar.setData(Uri.parse("tel:0377778888"));
				startActivity(ittDiscar);
 			}
 
		});
 
	}
 
}
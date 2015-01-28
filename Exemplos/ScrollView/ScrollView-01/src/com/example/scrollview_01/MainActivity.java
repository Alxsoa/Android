package com.example.scrollview_01;

import android.os.Bundle;
import android.app.Activity;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.MeuLayout);
		for (int iAux=0; iAux < 100; iAux++)
		{
			TextView text = new TextView (this);
			text.setLayoutParams (new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
			text.setText ("Linha de Texto Numero "+iAux);
			layout.addView(text);
		}
		
	}
}



package com.example.data_01;

import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class ParseStarterProjectActivity extends Activity 
{
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseObject testObject = new ParseObject("MeusDados");
		testObject.put ("Nome", "Fernando" ); 
		testObject.put ("SobreNome", "Queiros");
		testObject.put ("Idade", 30);
		testObject.put ("Sexo", "M");
		testObject.saveInBackground(new SaveCallback() 
		{
			public void done(com.parse.ParseException e) 
			{
                if (e == null) 
                {
                    Toast.makeText(getApplicationContext(), "Dados Salvos com Sucesso", Toast.LENGTH_SHORT).show();
                } 
                else 
                {
                    Toast.makeText(getApplicationContext(), "Falha no Salvamento dos Dados", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
		ParseAnalytics.trackAppOpened(getIntent());			
	}
}

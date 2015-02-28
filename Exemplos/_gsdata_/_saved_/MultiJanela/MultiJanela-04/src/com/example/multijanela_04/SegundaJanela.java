package com.example.multijanela_04;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaJanela extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segunda_janela);
		
        Intent intent = getIntent();
        String strJasonArray = intent.getStringExtra("Android");

        try 
        {
            JSONArray jsonData = new JSONArray(strJasonArray);
            System.out.println(jsonData.toString(2));
            
            TextView txtDados = (TextView) findViewById(R.id.idTxtMsg4);
    		txtDados.setText("Meu Texto = [" +jsonData.toString(2) + "]" );
        } 
        catch (JSONException e) 
        {
            e.printStackTrace();
        }

	}
}

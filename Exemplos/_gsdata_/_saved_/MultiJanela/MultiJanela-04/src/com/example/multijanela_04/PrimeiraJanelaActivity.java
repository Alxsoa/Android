package com.example.multijanela_04;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class PrimeiraJanelaActivity extends Activity 
{
    final String strJson = "{ \"Android\" :[{ \"Nome\":\"Alexandre Soares\"," +
			 "\"Identidade\":\"12345\"," +
			 "\"Universidade\":\"UFRJ\"}," +
			"{ \"Nome\":\"Andre Kalsing\"," +
			  "\"Identidade\":\"67890\"," +
			  "\"Universidade\":\"UFRGS\"}] }";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeira_janela);   
        
        Button btnIniciar = (Button) findViewById(R.id.idBtnEnvia);
        btnIniciar.setOnClickListener(new OnClickListener() 
        {			
			@Override
			public void onClick(View v) 
			{
				try
				{
	               JSONObject jsonObjeto;
	               jsonObjeto = new JSONObject(strJson);
	               JSONArray jsonData = jsonObjeto.optJSONArray("Android");
	
	               Intent intent = new Intent(PrimeiraJanelaActivity.this, SegundaJanela.class);
	               intent.putExtra("Android", jsonData.toString());
	               startActivity(intent);
				}
	            catch (JSONException e) 
                {         
                    e.printStackTrace();
                }
			}
		});   
    }
}

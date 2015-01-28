package com.example.data_04;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

// Referencia
// http://www.ibm.com/developerworks/br/library/j-parse/

public class ParseStarterProjectActivity extends Activity 
{
	String TAG = "MeuLog";
	String strNome = null;
	String strSobreNome = null;
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		ParseQuery query = new ParseQuery("MeusDados");
		query.whereEqualTo("Status", "Ativo"); 
		query.countInBackground(new CountCallback() 
		{
		    public void done(int iRegistros, ParseException e) 
		    {
		        if (e == null) 
		        {
		            Log.v ( TAG, "Nœmero de Registros = "+iRegistros);
		        } 
		        else 
		        {
		            Log.v ( TAG, "[ERR] O Processo de Contagem Deu Errado");
		        }
		    }
		});
		
		ParseAnalytics.trackAppOpened(getIntent());
	}
}

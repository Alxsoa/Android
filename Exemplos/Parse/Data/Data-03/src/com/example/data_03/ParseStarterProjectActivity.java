package com.example.data_03;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class ParseStarterProjectActivity extends Activity 
{
	String TAG = "MeuLog";
	String strNome = null;
	String strSobreNome = null;
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		ParseQuery<ParseObject> query = ParseQuery.getQuery("MeusDados");
		query.whereEqualTo("Nome", "Alexandre");
		query.getFirstInBackground(new GetCallback<ParseObject>()
		{
			  public void done(ParseObject object, ParseException e) 
			  {
			    if (e == null) 
			    {
				      strNome = object.getString("Nome");
				      strSobreNome = object.getString("SobreNome");
				      Log.v(TAG, "Nome = "+strNome+" "+strSobreNome);
			    } 
			    else 
			    {
			      Log.v(TAG, "[ERRO] Acessando a Query para Recuperar os Dados");
			    }
			  }
		});
		
		ParseAnalytics.trackAppOpened(getIntent());
	}
}

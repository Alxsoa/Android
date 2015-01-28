package com.example.data_05;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

// Referencia
// http://www.ibm.com/developerworks/br/library/j-parse/
// https://www.parse.com/docs/android/api/com/parse/ParseQuery.html

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
		 query.whereEqualTo("Status", "Ativo");
		 query.orderByAscending("Nome"); 
		 query.whereGreaterThan("Idade", 30);
		 
		 query.findInBackground(new FindCallback<ParseObject>() 
		 {
		     public void done(List<ParseObject> MeuObjeto, ParseException e) 
		     {
		         if (e == null) 
		         {
		             for ( int iAux=0; iAux < MeuObjeto.size(); iAux++)
		             {
		              Log.v( TAG, "Registro = "+MeuObjeto.get(iAux).getString("Nome")+" "+MeuObjeto.get(iAux).getString("SobreNome"));
		             }
		             Toast.makeText(getApplicationContext(), "Dados Listados no Log", Toast.LENGTH_SHORT).show();
		         } 
		         else 
		         {
		        	 Toast.makeText(getApplicationContext(), "Problemas em Recuperar os Dados Solicitados", Toast.LENGTH_SHORT).show();
		         }
		     }
		 });
		
		ParseAnalytics.trackAppOpened(getIntent());
	}
}

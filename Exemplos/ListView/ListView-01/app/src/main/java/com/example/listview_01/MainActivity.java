package com.example.listview_01;

import java.util.ArrayList;
import java.util.Arrays;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity 
{
  private ListView mainListView ;
  private ArrayAdapter<String> listAdapter ;
  
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate (savedInstanceState);
    setContentView (R.layout.activity_main);
    mainListView = (ListView) findViewById( R.id.listaPrincipal );

    String[] meses = new String[] { 
    									"Janeiro", 
    									"Fevereiro", 
    									"Março",
    									"Abril",
    									"Maio", 
    									"Junho"
    							  };
    
    ArrayList<String> ListaConteudo = new ArrayList<String>();
    ListaConteudo.addAll( Arrays.asList(meses) );
    
    listAdapter = new ArrayAdapter<String>(this, R.layout.linha, ListaConteudo);
    listAdapter.add( "Julho" );
    listAdapter.add( "Agosto" );
    listAdapter.add( "Setembro" );
    listAdapter.add( "Outubro" );
    listAdapter.add( "Novembro" );
    listAdapter.add( "Dezembro" );
    
    mainListView.setAdapter( listAdapter );      
  }
}
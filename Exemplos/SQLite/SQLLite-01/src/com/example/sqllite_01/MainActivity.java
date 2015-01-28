package com.example.sqllite_01;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity 
{
    LinearLayout Linear;
    SQLiteDatabase mydb;
    private static String strNomeBanco 	= "Pessoas.db";    
    private static String strNomeTabela = "MinhaTabela";      
 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        Button btnCriaBanco=(Button)findViewById(R.id.idBtnCriaBanco);
        btnCriaBanco.setOnClickListener(new View.OnClickListener() 
        {			
			@Override
			public void onClick(View v) 
			{
				CriaTabela();
				Toast.makeText(getApplicationContext(), "Banco Criado.", Toast.LENGTH_SHORT).show();
			}
		});
             
        Button BtnInsereDados=(Button)findViewById(R.id.idBtnInsereDados);
        BtnInsereDados.setOnClickListener(new View.OnClickListener() 
        {			
			@Override
			public void onClick(View v) 
			{
				InsereDados();
				Toast.makeText(getApplicationContext(), "Dados Inseridos.", Toast.LENGTH_SHORT).show();
			}
		});
        
	   Button BtnDeletaDados=(Button)findViewById(R.id.idBtnDeletaDados);
	   BtnDeletaDados.setOnClickListener(new View.OnClickListener() 
	   {			
			@Override
			public void onClick(View v) 
			{
				DeletaDados();
				Toast.makeText(getApplicationContext(), "Dados Deletados.", Toast.LENGTH_SHORT).show();
			}
		});
        	    
       
	   Button BtnUpdateBanco=(Button)findViewById(R.id.idBtnUpdateBanco);
	   BtnUpdateBanco.setOnClickListener(new View.OnClickListener() 
	   {			
			@Override
			public void onClick(View v) 
			{
				AtualizaTabela();
				Toast.makeText(getApplicationContext(), "Tabela Atualizada.", Toast.LENGTH_SHORT).show();
			}
		});
	   
       
	   Button BtnRemoveBanco=(Button)findViewById(R.id.idBtnRemoveBanco);
	   BtnRemoveBanco.setOnClickListener(new View.OnClickListener() 
	   {			
			@Override
			public void onClick(View v) 
			{
				RemoveBanco();   
				Toast.makeText(getApplicationContext(), "Banco Removido.", Toast.LENGTH_SHORT).show();
			}
		});
    }

    public void CriaTabela()
    {
        try
        {
	        mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
	        mydb.execSQL("CREATE TABLE IF  NOT EXISTS "+ strNomeTabela +" (ID INTEGER PRIMARY KEY, NAME TEXT, PLACE TEXT);");
	        mydb.close();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Erro ao Criar o Banco de Dados", Toast.LENGTH_LONG).show();
        }
    }

    public void InsereDados()
    {
        try
        {
            mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, PLACE) VALUES('João da Silva','Ceará')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, PLACE) VALUES('Manoel dos Santos','Minas Gerais')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, PLACE) VALUES('Tereza dos Santos','Rio de Janeiro')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, PLACE) VALUES('Claudio dos Rios','Paraná')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, PLACE) VALUES('Juscelino Alves','Bahia')");
            mydb.execSQL("INSERT INTO " + strNomeTabela + "(NAME, PLACE) VALUES('Dario Pederneiras','Rio Grande do Sul')");
            mydb.close();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Erro ao Inserir Dados na Tabela", Toast.LENGTH_LONG);
        }
    }

    public void showTableValues()
    {
        try
        {
            mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
            Cursor allrows  = mydb.rawQuery("SELECT * FROM "+  strNomeTabela, null);
            System.out.println("COUNT : " + allrows.getCount());
            Integer cindex = allrows.getColumnIndex("NAME");
            Integer cindex1 = allrows.getColumnIndex("PLACE");
 
            TextView t = new TextView(this);
            t.setText("========================================");
            //Linear.removeAllViews();
            Linear.addView(t);
 
            if(allrows.moveToFirst())
            {
                do
                {
                    LinearLayout id_row   = new LinearLayout(this);
                    LinearLayout name_row = new LinearLayout(this);
                    LinearLayout place_row= new LinearLayout(this);
 
                    final TextView id_  = new TextView(this);
                    final TextView name_ = new TextView(this);
                    final TextView place_ = new TextView(this);
                    final TextView   sep  = new TextView(this);
 
                    String ID = allrows.getString(0);
                    String NAME= allrows.getString(1);
                    String PLACE= allrows.getString(2);
 
                    id_.setTextColor(Color.RED);
                    id_.setPadding(20, 5, 0, 5);
                    name_.setTextColor(Color.RED);
                    name_.setPadding(20, 5, 0, 5);
                    place_.setTextColor(Color.RED);
                    place_.setPadding(20, 5, 0, 5);
 
                    System.out.println("NAME " + allrows.getString(cindex) + " PLACE : "+ allrows.getString(cindex1));
                    System.out.println("ID : "+ ID  + " || NAME " + NAME + "|| PLACE : "+ PLACE);
 
                    id_.setText("ID : " + ID);
                    id_row.addView(id_);
                    Linear.addView(id_row);
                    name_.setText("NAME : "+NAME);
                    name_row.addView(name_);
                    Linear.addView(name_row);
                    place_.setText("PLACE : " + PLACE);
                    place_row.addView(place_);
                    Linear.addView(place_row);
                    sep.setText("---------------------------------------------------------------");
                    Linear.addView(sep);
                }
                while(allrows.moveToNext());
            }
            mydb.close();
         }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Erro Encontrado", Toast.LENGTH_LONG).show();
        }
    }
    
    public void AtualizaTabela()
    {
        try
        {
            mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
            mydb.execSQL("UPDATE " + strNomeTabela + " SET NAME = 'MAX' WHERE PLACE = 'Rio de Janeiro'");
            mydb.close();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Erro Encontrado", Toast.LENGTH_LONG).show();
        }
    }

    public void DeletaDados()
    {
      try
      {
            mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
            mydb.execSQL("DELETE FROM " + strNomeTabela + " WHERE PLACE = 'Rio de Janeiro'");
            mydb.close();
      }
      catch(Exception e)
      {
            Toast.makeText(getApplicationContext(), "Erro ao Deletar Dados do Banco.", Toast.LENGTH_LONG).show();
      }
    }
    
    // THIS FUNTION DROPS A TABLE 
    public void RemoveBanco()
    {
        try
        {
            mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
            mydb.execSQL("DROP TABLE " + strNomeTabela);
            mydb.close();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Erro ao Descartar o Banco.", Toast.LENGTH_LONG).show();
        }
    }
}
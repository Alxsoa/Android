package com.example.sqllite_02;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
 
        Linear  = (LinearLayout)findViewById(R.id.linear);
        showTableValues();
    }

    public void showTableValues()
    {
        try
        {
            mydb = openOrCreateDatabase(strNomeBanco, Context.MODE_PRIVATE,null);
            Cursor allrows  = mydb.rawQuery("SELECT * FROM "+  strNomeTabela, null);
            Integer cindex = allrows.getColumnIndex("NAME");
            Integer cindex1 = allrows.getColumnIndex("PLACE");
 
            TextView t = new TextView(this);
            t.setText("========================================");
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
 
                    Log.v ( "MeuLog", "NAME " + allrows.getString(cindex) + 
                    		          " PLACE : "+ allrows.getString(cindex1) + 
                    		          " ID : "+ ID  + " || NAME " + NAME + "|| PLACE : "+ PLACE);
 
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
            Toast.makeText(getApplicationContext(), "Erro Encontrado", Toast.LENGTH_LONG);
        }
    }
}
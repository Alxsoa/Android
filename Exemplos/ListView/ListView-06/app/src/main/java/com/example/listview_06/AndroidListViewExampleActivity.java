package com.example.listview_06;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;

public class AndroidListViewExampleActivity extends ListActivity 
{
	 String[] Pessoas = new String[] {
										"Alexandre Soares",
										"Rua Castorina Faria Lima",
										
										"Henrique Morbin",
										"Rua da Independencia",
										
										"Luiz Gustavo",
										"Rua da Alice",
										
										"Dimitri Tallemberg",
										"Rua Dario Pederneiras"				
									};
	 
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
   	    setContentView(R.layout.principal);

        List<Contatos> data = new ArrayList<Contatos>();
        for (int i = 0; i < 8; i=i+2) 
        {
        	data.add(new Contatos("Contato: " + Pessoas[i], "Endereço: " + Pessoas[i+1]));
		}
        setListAdapter(new ContatosArrayAdapter(this, data));
    }
}


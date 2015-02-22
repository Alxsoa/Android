package com.example.listview_05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleListItem extends Activity
{
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_list_item_view);
        
        TextView txtProduct = (TextView) findViewById(R.id.meses);
        Intent i = getIntent();
        String sMesRecebido = i.getStringExtra("dados");
        
        if ( sMesRecebido.equals("Janeiro") || sMesRecebido.equals("Maio") 	 ||        	 
        	 sMesRecebido.equals("Julho") 	|| sMesRecebido.equals("Agosto") ||    
        	 sMesRecebido.equals("Outubro") || sMesRecebido.equals("Março")  ||
        	 sMesRecebido.equals("Dezembro") ) 
        {
        	txtProduct.setText( "31 Dias"); 
        }
        else
        {
            if ( sMesRecebido.equals("Fevereiro") ) 
            {
                txtProduct.setText( "28 Dias"); 
            }
            else
            {
                if ( sMesRecebido.equals("Abril") 	 || sMesRecebido.equals("Junho") ||        	 
                   	 sMesRecebido.equals("Setembro") || sMesRecebido.equals("Novembro") ) 
                {
                   	txtProduct.setText( "30 Dias"); 
                }
            }          
        }
	}
}

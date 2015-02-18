package com.example.toast_03;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		Button btnEvento = (Button) findViewById(R.id.idBtnToast);
		btnEvento.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {
	        	Context contexto = getApplicationContext(); 
	        	String texto = "Toast de Longa Duração";
	        	int duracao = Toast.LENGTH_LONG;
	        	Toast toast = Toast.makeText(contexto, texto, duracao);
	        	toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0); 
	        	toast.show();
	        }
	    });
    }
}

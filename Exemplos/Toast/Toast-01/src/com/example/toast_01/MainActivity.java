package com.example.toast_01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
	        	String texto = "Toast de Curta Duração"; 
	        	int duracao = Toast.LENGTH_SHORT;
	        	Toast toast = Toast.makeText(contexto, texto, duracao);
	            toast.show();        	
	        }
	    });
    }
}

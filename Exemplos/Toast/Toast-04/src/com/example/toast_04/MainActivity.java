package com.example.toast_04;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
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
	        	String texto = "Exemplo Toast";
	            LayoutInflater layoutInflater = getLayoutInflater(); 
	            int layout = R.layout.toast; 
	            
	            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.toast_layout_root); 
	            View view = layoutInflater.inflate(layout, viewGroup); 
	            TextView tv_texto = (TextView) view.findViewById(R.id.texto); 
	            tv_texto.setText(texto); 
	            
	            Toast toast = new Toast(getApplicationContext()); 
	            toast.setDuration(Toast.LENGTH_LONG); 
	            toast.setView(view); 
	            toast.show();
	        }
	    });
     }
}

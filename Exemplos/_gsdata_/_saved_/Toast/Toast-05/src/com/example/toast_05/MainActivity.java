package com.example.toast_05;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity 
{
 
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		Button btnCustomToast = (Button)findViewById(R.id.idBtnShowToast); 
		btnCustomToast.setOnClickListener(new View.OnClickListener() 
		{	
			@Override
			public void onClick(View v) 
			{		
				LayoutInflater inflater = getLayoutInflater();
				View layouttoast = inflater.inflate ( R.layout.toastcustom, 
													  (ViewGroup)findViewById(R.id.toastcustom));
				((TextView) layouttoast.findViewById(R.id.texttoast)).setText("Toast Customizado");
				
				Toast mytoast = new Toast(getBaseContext());
		        mytoast.setView(layouttoast);
		        mytoast.setDuration(Toast.LENGTH_LONG);
		        mytoast.show();
			}
		});  
    } 
}
 
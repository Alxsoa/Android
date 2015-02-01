package com.example.edittext_03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnOk = (Button) findViewById(R.id.btnOk);
		btnOk.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {
	        	EditText edtSenha = (EditText)findViewById(R.id.edtSenha);
	        	Toast.makeText( MainActivity.this, 
	        					"A Senha Digita Foi " + edtSenha.getText().toString(), 
	        					Toast.LENGTH_SHORT).show();
	        }
		});		
	}
}

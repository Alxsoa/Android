package com.example.sms_02;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.telephony.SmsManager;

public class MainActivity extends Activity
{
	
	private EditText edtNumeroTel;
	private EditText edtMsgTxt;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        edtNumeroTel = (EditText)findViewById(R.id.edtNumeroTelefone);
        edtMsgTxt    = (EditText)findViewById(R.id.edtMensagem);

        Button codeButton = (Button) findViewById(R.id.btnSendSms);               
        codeButton.setOnClickListener(new View.OnClickListener() 
        {
		  public void onClick(View view) 
		  {		
			  
			  SmsManager smsManager = SmsManager.getDefault();        
			  if(edtMsgTxt.getText().toString().trim().length() > 160) 
			  {
			        ArrayList<String> parts = smsManager.divideMessage(edtMsgTxt.getText().toString()); 
			        smsManager.sendMultipartTextMessage(edtNumeroTel.getText().toString(), null, parts, null, null);        
			        Toast.makeText(getApplicationContext(), "Mensagem Enviada", Toast.LENGTH_LONG).show();
			  }
			  else 
			  {			        
				  smsManager.sendTextMessage(edtNumeroTel.getText().toString(), null, edtMsgTxt.getText().toString(), null, null);       
			      Toast.makeText(getApplicationContext(), "Mensagem Enviada", Toast.LENGTH_LONG).show();				        
			  }
		  }
        });                                       
    }           
}


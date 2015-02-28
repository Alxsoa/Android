package com.example.intent_02;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityCustomizada extends Activity 
{
   @Override
   public void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.custom_view);

      TextView txtEndereco = (TextView) findViewById(R.id.idTxtEndereco);

      Uri uriEndereco = getIntent().getData();
      txtEndereco.setText(uriEndereco.toString());
   }
	
}
package com.javacodegeeks.android.intentfiltertest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MySmsActivity extends Activity {

	 @Override
	   public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.intent_view);

	      String output = null;
	      TextView dataIntent = (TextView) findViewById(R.id.output_intent);
	    
	      // take the data and the extras of the intent
	      Uri url = getIntent().getData();
	      Bundle extras = getIntent().getExtras();
	      
	      output = url.toString();
	      // if there are extras, add them to the output string
	      if(extras != null){
	    	  output = output+ " from "+ extras.getString("from");
	      }
	      dataIntent.setText(output);
	   }
}
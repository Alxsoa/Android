package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class ParseStarterProjectActivity extends Activity 
{
	String TAG = "MeuLog";
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ParseUser user = new ParseUser();
		user.setUsername("alxsoa");
		user.setPassword("Toor00--");
		user.setEmail("alexandre.asoares@gmail.com");
		  
		// other fields can be set just like with ParseObject
		user.put("phone", "+55-51-8035-1686");
		  
		user.signUpInBackground(new SignUpCallback() 
		{
		  public void done(ParseException e) 
		  {
		    if (e == null) 
		    {
		      Log.v(TAG, "Pronto para Uso");
		    } 
		    else 
		    {
			  Log.v(TAG, "Deu Problema");
		    }
		  }
		});
		
		ParseFacebookUtils.logIn(this, new LogInCallback() {
			  public void Logindone(ParseUser user, ParseException err) {
			    if (user == null) {
			      Log.d(TAG, "Uh oh. The user cancelled the Facebook login.");
			    } else if (user.isNew()) {
			      Log.d(TAG, "User signed up and logged in through Facebook!");
			    } else {
			      Log.d(TAG, "User logged in through Facebook!");
			    }
			  }

			@Override
			public void done(ParseUser user, ParseException e) {
				// TODO Auto-generated method stub
				
			}
			});
		
		ParseAnalytics.trackAppOpened(getIntent());
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
	  super.onActivityResult(requestCode, resultCode, data);
	  ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}
}

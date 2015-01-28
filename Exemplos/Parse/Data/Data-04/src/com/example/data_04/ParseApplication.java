package com.example.data_04;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

// Referencia
// http://www.michaelevans.org/blog/2013/08/14/tutorial-building-an-android-to-do-list-app-using-parse/
//

public class ParseApplication extends Application 
{

  @Override
  public void onCreate() 
  {
    super.onCreate();

    // Add your initialization code here
    Parse.initialize (	this, 
    					"fcT80QLTVSwE2Q2trgWjMJ1hbJ4KvYb32UvzWpCP", 
    					"46xF5awXuYb9FZ04P0RDL0QUQ5k5fboEbkoNiR27");


    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
      
    // If you would like all objects to be private by default, remove this line.
    defaultACL.setPublicReadAccess(true);    
    ParseACL.setDefaultACL(defaultACL, true);
  }
}

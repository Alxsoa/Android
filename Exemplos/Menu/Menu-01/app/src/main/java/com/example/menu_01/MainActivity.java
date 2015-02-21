package com.example.menu_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        
        switch (item.getItemId())
        {
	        case R.id.menu_bookmark:
	            	Toast.makeText(	MainActivity.this, 
	            					"Opcao Bookmark Foi Selecionada", 
	            					Toast.LENGTH_SHORT).show();
    				return true;
    				
	        case R.id.menu_save:
		        	Toast.makeText(	MainActivity.this, 
		        					"Opcao Save Foi Selecionada", 
		        					Toast.LENGTH_SHORT).show();
		            return true;
		            
	        case R.id.menu_search:
		        	Toast.makeText(	MainActivity.this, 
		        					"Opcao Search Foi Selecionada", 
		        					Toast.LENGTH_SHORT).show();
		            return true;
		            
	        case R.id.menu_share:
		        	Toast.makeText(	MainActivity.this, 
		        					"Opcao Share Foi Selecionada", 
		        					Toast.LENGTH_SHORT).show();
		            return true;
		            
	        case R.id.menu_delete:
		        	Toast.makeText(	MainActivity.this, 
		        					"Opcao Delete Foi Selecionada", 
		        					Toast.LENGTH_SHORT).show();
		            return true;
		            
	        case R.id.menu_preferences:
		        	Toast.makeText(	MainActivity.this, 
		        					"Opcao Preferences Foi Selecionada", 
		        					Toast.LENGTH_SHORT).show();
		            return true;
		            
	        default:
	            	return super.onOptionsItemSelected(item);
        }
    }
    

}
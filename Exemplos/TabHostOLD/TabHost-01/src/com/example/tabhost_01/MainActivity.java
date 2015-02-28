package com.example.tabhost_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity 
{
    TabHost tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState)
     {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.main);
       
        tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
      
        TabSpec spec1=tabHost.newTabSpec("TAB 1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("TAB #1");
      
        TabSpec spec2=tabHost.newTabSpec("TAB 2");
        spec2.setIndicator("TAB #2");
        spec2.setContent(R.id.tab2);
            
        TabSpec spec3=tabHost.newTabSpec("TAB 3");
        spec3.setContent(R.id.tab3);
        spec3.setIndicator("TAB #3");
        
        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);   
    }           
}

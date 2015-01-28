package com.example.applist_01;

import java.util.List;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInstalledApps();
    }
    
    public void getInstalledApps()
    {
        List<PackageInfo> PackList = getPackageManager().getInstalledPackages(0);
        for (int i=0; i < PackList.size(); i++)
           {
             PackageInfo PackInfo = PackList.get(i);
             if(((PackInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) != true)
               {
                  String AppName = PackInfo.applicationInfo.loadLabel(getPackageManager()).toString();
                  Log.v("MeuLog", "Aplicacao Instalada ["+AppName+"]");
               }
           }
     }
}

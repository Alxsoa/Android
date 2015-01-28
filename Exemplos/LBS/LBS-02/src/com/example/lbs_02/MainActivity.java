package com.example.lbs_02;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{ 
    private static final long DISTANCIA_MINIMA_PARA_UPDATES = 1; 	// em Metros
    private static final long TEMPO_ENTRE_UPDATES = 1000; 			// em Milisegundos
    
    protected LocationManager locationManager;    
    protected Button retrieveLocationButton;
    
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrieveLocationButton = (Button) findViewById(R.id.idPegaPosicao);        
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates ( LocationManager.NETWORK_PROVIDER, TEMPO_ENTRE_UPDATES, 
        		DISTANCIA_MINIMA_PARA_UPDATES, new MyLocationListener() );
                        
	    retrieveLocationButton.setOnClickListener(new OnClickListener() 
	    {
            @Override
            public void onClick(View v) 
            {
                showCurrentLocation();
            }
	    });                
    }    

    protected void showCurrentLocation() 
    {
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (location != null) 
        {
            String message = String.format ( "Localizacao Atual \n Longitude: %1$s \n Latitude: %2$s", location.getLongitude(), location.getLatitude() );
            Toast.makeText ( MainActivity.this, message, Toast.LENGTH_LONG).show();
        }
    }   

    private class MyLocationListener implements LocationListener 
    {
        public void onLocationChanged(Location location) 
        {
            String message = String.format( "Nova Localizacao \n Longitude: %1$s \n Latitude: %2$s", location.getLongitude(), location.getLatitude() );
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        }

        public void onStatusChanged(String s, int i, Bundle b) 
        {
            Toast.makeText(MainActivity.this, "Mudanca de Status do Provedor", Toast.LENGTH_LONG).show();
        }

        public void onProviderDisabled(String s) 
        {
            Toast.makeText(MainActivity.this, "GPS foi Desativado Pelo Usuario", Toast.LENGTH_LONG).show();
        }

        public void onProviderEnabled(String s) 
        {
            Toast.makeText(MainActivity.this, "GPS foi Ativado Pelo Usuario", Toast.LENGTH_LONG).show();
        }
    }
    
}
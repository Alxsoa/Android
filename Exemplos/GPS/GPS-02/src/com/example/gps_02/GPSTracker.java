package com.example.gps_02;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class GPSTracker extends Service implements LocationListener 
{

	private final Context ctxContexto;	
	boolean bGPS = false;				// Indica o GPS Staus
	boolean bNetwork = false;			// Indica o Status da Rede
	boolean bGetLocalizacao = false;	// Indica Status de Pegar a Localizacao
	Location location; 					// Localizacao
	double dLatitude; 					// Guarda a Latitude
	double dLongitude; 					// Guarda a Longitude
	private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 Metros
	private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;  // 1 Minute
	protected LocationManager lcmGerencia;

	public GPSTracker(Context context) 
	{
		this.ctxContexto = context;
		getLocation();
	}

	public Location getLocation() 
	{
		try 
		{
			lcmGerencia = (LocationManager) ctxContexto.getSystemService(LOCATION_SERVICE);
			bGPS = lcmGerencia.isProviderEnabled(LocationManager.GPS_PROVIDER);
			bNetwork = lcmGerencia.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

			if (!bGPS && !bNetwork) 
			{
				// N‹o Tem Rede 
			} 
			else 
			{
				this.bGetLocalizacao = true;
				if (bNetwork) 
				{
					lcmGerencia.requestLocationUpdates ( LocationManager.NETWORK_PROVIDER,
														 MIN_TIME_BW_UPDATES,
														 MIN_DISTANCE_CHANGE_FOR_UPDATES, 
														 this   );
				
					if (lcmGerencia != null) 
					{
						location = lcmGerencia.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						if (location != null) 
						{
							dLatitude  = location.getLatitude();
							dLongitude = location.getLongitude();
						}
					}
				}

				if (bGPS) 
				{
					if (location == null) 
					{
						lcmGerencia.requestLocationUpdates	( LocationManager.GPS_PROVIDER,
															  MIN_TIME_BW_UPDATES,
															  MIN_DISTANCE_CHANGE_FOR_UPDATES, 
															  this );
						if (lcmGerencia != null) 
						{
							location = lcmGerencia.getLastKnownLocation(LocationManager.GPS_PROVIDER);
							if (location != null) 
							{
								dLatitude = location.getLatitude();
								dLongitude = location.getLongitude();
							}
						}
					}
				}
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return location;
	}
	
	public void stopUsingGPS()
	{
		if(lcmGerencia != null)
		{
			lcmGerencia.removeUpdates(GPSTracker.this);
		}		
	}
	
	public double getLatitude()
	{
		if(location != null)
		{
			dLatitude = location.getLatitude();
		}
		return dLatitude;
	}
	
	public double getLongitude()
	{
		if(location != null)
		{
			dLongitude = location.getLongitude();
		}
		return dLongitude;
	}
	
	public boolean canGetLocation() 
	{
		return this.bGetLocalizacao;
	}
	
	public void showSettingsAlert()
	{
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(ctxContexto);
   	 
        alertDialog.setTitle("GPS N‹o Est‡ Ativo");
        alertDialog.setMessage("Voce Deseja Configura-lo Agora");
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog,int which) 
            {
            	Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            	ctxContexto.startActivity(intent);
            }
        });
 
        alertDialog.setNegativeButton("N‹o", new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int which) 
            {
            dialog.cancel();
            }
        });
        alertDialog.show();
	}

	@Override
	public void onLocationChanged(Location location) 
	{
	}

	@Override
	public void onProviderDisabled(String provider) 
	{
	}

	@Override
	public void onProviderEnabled(String provider) 
	{
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) 
	{
	}

	@Override
	public IBinder onBind(Intent arg0) 
	{
		return null;
	}

}

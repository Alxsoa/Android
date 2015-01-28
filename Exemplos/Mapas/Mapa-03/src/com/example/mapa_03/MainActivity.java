package com.example.mapa_03;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.CancelableCallback;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends FragmentActivity 
{
	private SupportMapFragment mapFrag;
	private GoogleMap map;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		GoogleMapOptions options = new GoogleMapOptions();
		options.zOrderOnTop(true);
		
		mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.fragment1);		
		map = mapFrag.getMap();
		configMap();
	}
	
	
	@Override
	public void onResume()
	{
		super.onResume();
	}
	
	
	public void configMap(){
		map = mapFrag.getMap();
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		LatLng latLng = new LatLng(-23.564224, -46.653156);
//
//		Estas linhas devem ser apresentadas individualmente
//
		//CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(18).bearing(0).tilt(90).build();
		CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(18).build();
		//CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).build();
	
		CameraUpdate update = CameraUpdateFactory.newCameraPosition(cameraPosition);
		
		map.animateCamera(update, 3000, new CancelableCallback()
		{
			@Override
			public void onCancel() 
			{
				Log.i("verbose", "CancelableCallback.onCancel()");
			}

			@Override
			public void onFinish() 
			{
				Log.i("verbose", "CancelableCallback.onFinish()");
			}
		});
	}
}






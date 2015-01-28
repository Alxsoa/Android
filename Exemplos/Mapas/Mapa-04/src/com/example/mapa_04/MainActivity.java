package com.example.mapa_04;

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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity 
{
	private SupportMapFragment mapFrag;
	private GoogleMap map;
	private Marker marker;
	
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
		
		// Marcador
		customAddMarker(new LatLng(-23.564224, -46.653156), "Marcador 1", "Apresentado o Marcador 1");
		customAddMarker(new LatLng(-23.564205, -46.653102), "Marcador 2", "Apresentado o Marcador 2");
					
		// Eventos
		map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() 
		{
			@Override
			public void onCameraChange(CameraPosition cameraPosition) 
			{
				Log.i("verbose", "setOnCameraChangeListener()");
				
				/*if(marker != null)
				{
					marker.remove();
				}
				customAddMarker(new LatLng(cameraPosition.target.latitude, cameraPosition.target.longitude), "1: Marcador Alterado", "O Marcador foi reposicionado");
				*/
			}
		});
					
		map.setOnMapClickListener(new GoogleMap.OnMapClickListener() 
		{
			@Override
			public void onMapClick(LatLng latLng) 
			{
				Log.i("verbose", "setOnMapClickListener()");
				/*if(marker != null)
				{
					marker.remove();
				}
				customAddMarker(new LatLng(latLng.latitude, latLng.longitude), "2: Marcador Alterado", "O Marcador foi reposicionado");
				*/
			}
		});
					
		map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() 
		{
			@Override
			public boolean onMarkerClick(Marker marker) 
			{
				Log.i("verbose", "3: Marker: "+marker.getTitle());
				return false;
			}
		});
					
		map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() 
		{
			@Override
			public void onInfoWindowClick(Marker marker) 
			{
				Log.i("verbose", "4: Marker: "+marker.getTitle());
			}
		});
	}
	
	public void customAddMarker(LatLng latLng, String title, String snippet)
	{
		MarkerOptions options = new MarkerOptions();
//
//		Permite ou Nao a movimentacao
//
		options.position(latLng).title(title).snippet(snippet).draggable(true);
		//options.position(latLng).title(title).snippet(snippet).draggable(false);
		
		marker = map.addMarker(options);
	}
}






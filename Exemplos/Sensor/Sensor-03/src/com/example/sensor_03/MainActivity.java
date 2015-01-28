package com.example.sensor_03;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	  TextView txtLux;
	  
	  @Override
	  public final void onCreate(Bundle savedInstanceState) 
	  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtLux	= (TextView)findViewById(R.id.idTxtLux);
		SensorManager snmGerente = (SensorManager)getSystemService(SENSOR_SERVICE);
	    Sensor snsLuz = snmGerente.getDefaultSensor(Sensor.TYPE_LIGHT);
	    
	    if ( snsLuz != null )
	    {
	    	snmGerente.registerListener(LightSensorListener, snsLuz, SensorManager.SENSOR_DELAY_NORMAL);   
	    }
	    else
	    {
	    	Toast.makeText(getApplicationContext(), "Sensor N‹o Suportado", Toast.LENGTH_SHORT).show();
	    	finish ();
	    }	    
	  }
	  
	  private final SensorEventListener LightSensorListener = new SensorEventListener()
	  {
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) 
		{	    
		}
		
		@Override
		public void onSensorChanged(SensorEvent snsEvento) 
		{
			if(snsEvento.sensor.getType() == Sensor.TYPE_LIGHT)
		    {
				txtLux.setText("Lux : " + " " + snsEvento.values[0] + " lx");		
		    }
		}
	};
}
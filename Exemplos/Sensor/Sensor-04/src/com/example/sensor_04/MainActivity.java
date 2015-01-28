package com.example.sensor_04;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity implements SensorEventListener
{
	private SensorManager snmSensorGerente;
	private Sensor snmSensor;
	ImageView imgImagem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		snmSensorGerente = (SensorManager)getSystemService(SENSOR_SERVICE);
		snmSensor = snmSensorGerente.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		imgImagem = (ImageView)findViewById(R.id.idImgView);
	}

	protected void onResume() 
	{
		super.onResume();
		snmSensorGerente.registerListener(this, snmSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	protected void onPause() 
	{
		super.onPause();
		snmSensorGerente.unregisterListener(this);
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy) 
	{
	}

	public void onSensorChanged(SensorEvent event) 
	{
		if(event.values[0] == 0)
		{
			imgImagem.setImageResource(R.drawable.perto);
		}
		else
		{
			imgImagem.setImageResource(R.drawable.longe);
		}
	}
}
package com.example.sensor_02;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener 
{
	  private SensorManager snmGerente;
	  private Sensor snsAcelerometro;
	  private long lTempoAnterior = 0;
	  
	  TextView txtPosX;
	  TextView txtPosY;
	  TextView txtPosZ;
	  
	  @Override
	  public final void onCreate(Bundle savedInstanceState) 
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    snmGerente 		= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    snsAcelerometro = snmGerente.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	    
	    if ( snsAcelerometro == null )
	    {
	    	Toast.makeText(getApplicationContext(), "Sensor N‹o Suportado", Toast.LENGTH_SHORT).show();
	    	finish ();
	    }
	    else
	    {
		    snmGerente.registerListener(this, snsAcelerometro , SensorManager.SENSOR_DELAY_NORMAL);
		    txtPosX	= (TextView)findViewById(R.id.idXPos);
		    txtPosY	= (TextView)findViewById(R.id.idYPos);
		    txtPosZ	= (TextView)findViewById(R.id.idZPos);
	    }
	  }

	  @Override
	  public final void onAccuracyChanged(Sensor sensor, int accuracy)
	  {
	  }

	  @Override
	  public final void onSensorChanged(SensorEvent snsEvento) 
	  {	     
	    long lTempoAtual = System.currentTimeMillis();
        if ((lTempoAtual - lTempoAnterior) > 500) 
        {
            lTempoAnterior = lTempoAtual;
		    if (snsAcelerometro.getType() == Sensor.TYPE_ACCELEROMETER) 
		    {
				txtPosX.setText("Eixo X : " + " " + snsEvento.values[0] + " m/s2");
				txtPosY.setText("Eixo Y : " + " " + snsEvento.values[1] + " m/s2");
				txtPosZ.setText("Eixo Z : " + " " + snsEvento.values[2] + " m/s2");	  
		    }  	 
        }
	  }

	  @Override
	  protected void onResume()
	  {
	    super.onResume();
	    snmGerente.registerListener(this, snsAcelerometro, SensorManager.SENSOR_DELAY_NORMAL);
	  }

	  @Override
	  protected void onPause() 
	  {
	    super.onPause();
	    snmGerente.unregisterListener(this);
	  }
	}
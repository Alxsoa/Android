package com.example.sensor_01;


import java.util.List;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity 
{
   private SensorManager snsSensor;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      
      TextView sensorsData = (TextView)findViewById(R.id.idTxtLinha);
      snsSensor = (SensorManager)this.getSystemService(SENSOR_SERVICE);
      
      List<Sensor> lstSensorLista = snsSensor.getSensorList(Sensor.TYPE_ALL);

      StringBuilder data = new StringBuilder();
      for(Sensor sensor: lstSensorLista)
      {
         data.append( "Sensor \t\t\t\t = " + sensor.getName() + "\n");
         data.append( "Fabricante \t = " + sensor.getVendor() + "\n");
         data.append( "Vers‹o \t\t\t\t = " + sensor.getVersion() + "\n");
         data.append( "+--------------------------------------------------------------+\n");

      }
      sensorsData.setText(data);
   }
}
package com.example.shared_01;

//
// http://www.tutorialspoint.com/android/android_shared_preferences.htm
//

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity 
{
   TextView txtNome ;
   TextView txtApelido;
   public static final String strPreferencia = "LocalPref" ;
   public static final String strNome  = "ChaveNome"; 
   public static final String strApelido = "ChaveApelido"; 

   SharedPreferences shrLocal;

   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      txtNome = (TextView) findViewById(R.id.idEdtNome);
      txtApelido = (TextView) findViewById(R.id.idEdtIdade);

      shrLocal = getSharedPreferences(strPreferencia, Context.MODE_PRIVATE);

      if (shrLocal.contains(strNome))
      {
         txtNome.setText(shrLocal.getString(strNome, ""));
      }

      if (shrLocal.contains(strApelido))
      {
         txtApelido.setText(shrLocal.getString(strApelido, ""));
      }
   }

   public void muda(View view)
   {    
      Editor editor = shrLocal.edit();
      editor.putString(strNome, "Dimitri");
      editor.putString(strApelido, "Dimi");
      editor.apply();
      editor.commit();
   }
   
   public void limpa(View view)
   {    
      Editor editor = shrLocal.edit();
      editor.clear(); 
      editor.commit();
   }
   
   public void salva(View view)
   {
      String strAuxNome  = txtNome.getText().toString();
      String strAuxIdade  = txtApelido.getText().toString();
      
      Editor editor = shrLocal.edit();
      editor.putString (strNome, strAuxNome);
      editor.putString (strApelido, strAuxIdade);
      editor.commit(); 
   }
}
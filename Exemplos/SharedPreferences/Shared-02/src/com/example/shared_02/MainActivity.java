package com.example.shared_02;

//
// http://www.tutorialspoint.com/android/android_shared_preferences.htm
//
// ver a documentacao oficial http://developer.android.com/reference/android/content/Context.html porque l‡ 
// diz por exemplo o world readable foi depreciado
//
// putLong(String key, long value) = It will save a long value in a preference editor
// putInt(String key, int value) = It will save a integer value in a preference editor
// putFloat(String key, float value)
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
   TextView txtIdade;
   public static final String strPreferencia = "LocalPref" ;
   public static final String strNome  = "ChaveNome"; 
   public static final String strIdade = "ChaveIdade"; 
   
   SharedPreferences shrLocal;

   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      txtNome = (TextView) findViewById(R.id.idEdtNome);
      txtIdade = (TextView) findViewById(R.id.idEdtIdade);

      shrLocal = getSharedPreferences(strPreferencia, Context.MODE_PRIVATE);

      if (shrLocal.contains(strNome))
      {
         txtNome.setText(shrLocal.getString(strNome, ""));
      }

     if (shrLocal.contains(strIdade))
      {
    	 int iIdade = shrLocal.getInt(strIdade,0);
    	 String testString = Integer.toString(iIdade);
         txtIdade.setText(testString);
      } 
   }

   public void muda(View view)
   {    
      Editor editor = shrLocal.edit();
      editor.putString(strNome, "Dimitri");
      editor.putInt(strIdade, 99); 
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
      String strAuxIdade  = txtIdade.getText().toString();
      int iAux = Integer.parseInt(strAuxIdade);
      
      Editor editor = shrLocal.edit();
      editor.putString (strNome, strAuxNome);
      editor.putInt(strIdade, iAux); 
      editor.commit(); 
   }
}
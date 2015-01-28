package com.example.jason_01;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

/*
{ 
   "Android" :
    [
       {
          "Nome":"Alexandre Soares",
          "Identidade":"12345",
          "Universidade":"UFRJ"
       }, 
       {
          "Nome":"Andre Kalsing",
          "Identidade":"67890",
          "Universidade":"UFRGS"
       }
     ] 
}
*/

public class MainActivity extends Activity 
{
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);       
        final TextView txtOutput = (TextView) findViewById (R.id.idOutput);
        
//		===============================================================
// 		Definicao estatica do json utilizado
//		===============================================================        
        final String strJson = "{ \"Android\" :[{ \"Nome\":\"Alexandre Soares\"," +
        										 "\"Identidade\":\"12345\"," +
        										 "\"Universidade\":\"UFRJ\"}," +
        										"{ \"Nome\":\"Andre Kalsing\"," +
        										  "\"Identidade\":\"67890\"," +
        										  "\"Universidade\":\"UFRGS\"}] }";
         
        final Button btnJason    = (Button) findViewById (R.id.idJason);
        btnJason.setOnClickListener(new View.OnClickListener() 
        {
	        public void onClick(View v) 
            {       
               String strOutput = "";
               JSONObject jsonObjeto;
                     
               try 
               {
//           		===============================================================
//            		Recupera o mapeamento json, o nome do array e a quantidade
//           		===============================================================             	   
            	    jsonObjeto = new JSONObject(strJson);
                    JSONArray jsonMainNode = jsonObjeto.optJSONArray("Android");
                    int iTamanhoLista = jsonMainNode.length();  
 
                    for(int iAux=0; iAux < iTamanhoLista; iAux++) 
                    {
                        JSONObject jsonChildNode = jsonMainNode.getJSONObject(iAux);
                        int song_id        = Integer.parseInt(jsonChildNode.optString("Identidade").toString());
                        String song_name   = jsonChildNode.optString("Nome").toString();
                        String artist_name = jsonChildNode.optString("Universidade").toString();                         
                         
                        strOutput += "Dados : \n\n     " + song_id + " | "
                                                         + song_name + " | "
                                                         + artist_name + " \n\n ";
                   }
                     
//           	   ===============================================================
//            	   Apresenta o Resultado
//           	   ===============================================================  
                   txtOutput.setText( strOutput );                     
                } 
                catch (JSONException e) 
                {         
                    e.printStackTrace();
                }
            }
        });
    }
}

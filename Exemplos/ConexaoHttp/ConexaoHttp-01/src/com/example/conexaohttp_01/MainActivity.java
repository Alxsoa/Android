package com.example.conexaohttp_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity 
{
	EditText edtResposta;
	TextView txtConectado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		txtConectado = (TextView) findViewById(R.id.idTxtConectado);

		if(isConnected())
		{
			new HttpAsyncTask().execute("http://192.168.25.24:8888/hello.php");
        }
		else
		{
			txtConectado.setText("A Aplicação Não Está Conectada");
		}
	}

	public static String GET(String url)
	{
		InputStream inputStream = null;
		String result = "";
		try 
		{
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
			inputStream = httpResponse.getEntity().getContent();

			if(inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Não Funcionou";
		
		} 
		catch (Exception e) 
		{
			Log.d("MeuLog", e.getLocalizedMessage());
		}
		
		return result;
	}
	
    private static String convertInputStreamToString(InputStream inputStream) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        
        while((line = bufferedReader.readLine()) != null)
        {
            result += line;
        }
        
        inputStream.close();
        return result;      
    }
	
    public boolean isConnected()
    {
    	ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
    	NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    	
	    if (networkInfo != null && networkInfo.isConnected()) 
	    	return true;
	    else
	    	return false;	
    }
    
    private class HttpAsyncTask extends AsyncTask<String, Void, String> 
    {
        @Override
        protected String doInBackground(String... urls) 
        {              
            return GET(urls[0]);
        }

        @Override
        protected void onPostExecute(String result) 
        {
        	Toast.makeText(getBaseContext(), "Dados Recebidos com Sucesso", Toast.LENGTH_LONG).show();
        	txtConectado.setText(result);
       }
    }
}

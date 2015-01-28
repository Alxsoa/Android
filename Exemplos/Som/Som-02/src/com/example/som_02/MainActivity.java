package com.example.som_02;

import java.io.File;
import java.io.IOException;
import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private int output_formats[] = { MediaRecorder.OutputFormat.MPEG_4, MediaRecorder.OutputFormat.THREE_GPP };
	private MediaRecorder mdaGravacao = null;
    Button btnInicia, btnPara, btnMP4, btn3GP; 	
	private static final String AUDIO_3GP = ".3gp";
	private static final String AUDIO_MP4 = ".mp4";
	private static final String AUDIO_DIRETORIO = "Som";
	private String strTipoAudio[] = { AUDIO_MP4, AUDIO_3GP };
	int iTipoAudio = 0;
	String TAG = "MeuLog"; 
	
	private MediaRecorder.OnErrorListener errorListener = new MediaRecorder.OnErrorListener() 
	{
		@Override
		public void onError(MediaRecorder mr, int what, int extra) 
		{
			Toast.makeText(MainActivity.this,"Error: " + what + ", " + extra, Toast.LENGTH_SHORT).show();
		}
	};
	
	private MediaRecorder.OnInfoListener infoListener = new MediaRecorder.OnInfoListener() 
	{
		@Override
		public void onInfo(MediaRecorder mr, int what, int extra) 
		{
			Toast.makeText(MainActivity.this,"Warning: " + what + ", " + extra, Toast.LENGTH_SHORT).show();
		}
	};
	
	private String getFilename() 
	{
		String filepath = Environment.getExternalStorageDirectory().getPath();
		File file = new File(filepath, AUDIO_DIRETORIO);

		if (!file.exists()) 
		{
			file.mkdirs();
		}

		Log.v ( TAG, "Valor = "+file.getAbsolutePath() + "/" + System.currentTimeMillis() + strTipoAudio[iTipoAudio]);
		return (file.getAbsolutePath() + "/" + System.currentTimeMillis() + strTipoAudio[iTipoAudio]);
	}
    
	private void startRecording() 
	{	
		mdaGravacao = new MediaRecorder();
		mdaGravacao.setAudioSource(MediaRecorder.AudioSource.MIC);
		mdaGravacao.setOutputFormat(output_formats[iTipoAudio]);
		mdaGravacao.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		mdaGravacao.setOutputFile(getFilename());

		mdaGravacao.setOnErrorListener(errorListener);
		mdaGravacao.setOnInfoListener(infoListener);

		try 
		{
			mdaGravacao.prepare();
			mdaGravacao.start();
		} 
		catch (IllegalStateException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void stopRecording() 
	{
		if (null != mdaGravacao) 
		{
			mdaGravacao.stop();
			mdaGravacao.reset();
			mdaGravacao.release();
			mdaGravacao = null;
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnInicia = (Button) findViewById(R.id.idBtnInicia);
        btnPara   = (Button) findViewById(R.id.idBtnPara);
        btnMP4 	  = (Button) findViewById(R.id.idBtnMP4);
        btn3GP 	  = (Button) findViewById(R.id.idBtn3GP);
        
        btnInicia.setEnabled(false);
        btnPara.setEnabled(false);
        
        btn3GP.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {  
	        	iTipoAudio = 1;
	            btnInicia.setEnabled(true);
	            btnPara.setEnabled(true);
	            btnMP4.setEnabled(false);
	        }
	    });
        
        btnMP4.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {           
	        	iTipoAudio = 0;
	            btnInicia.setEnabled(true);
	            btnPara.setEnabled(true);
	            btn3GP.setEnabled(false);
	        }
	    });
        
        btnInicia.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {      
	        	Toast.makeText(getApplicationContext(),"Iniciando a Gravaçao", Toast.LENGTH_SHORT).show();
	        	btnInicia.setEnabled(false);
				startRecording();
	        }
	    });
        
        btnPara.setOnClickListener( new View.OnClickListener()
		{
	        @Override
	        public void onClick(View v) 
	        {   
	        	Toast.makeText(getApplicationContext(),"Fim da Gravaçao", Toast.LENGTH_SHORT).show();
	        	btnInicia.setEnabled(true);
	        	stopRecording();
	        }
	    });
    }
}

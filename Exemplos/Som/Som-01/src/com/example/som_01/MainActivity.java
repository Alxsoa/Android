package com.example.som_01;

import java.util.concurrent.TimeUnit;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
   public TextView 		txtTempoInicial,
   						txtTempoFinal;
   private MediaPlayer 	mdpTocador;
   private double 		dTempoInicial 	= 0;
   private double 		dTempoFinal 	= 0;
   private Handler 		hdlHandlerLocal = new Handler();;
   private int 			iTempoAvanco 	= 5000; 
   private int 			iTempoVolta 	= 5000;
   private SeekBar 		sekBarra;
   private ImageButton 	imgPlayBtn,
   						imgPauseBtn;
   public static int 	iApenasUmaVez = 0;
   
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      txtTempoInicial	= (TextView)findViewById(R.id.idTxtInicial);
      txtTempoFinal 	= (TextView)findViewById(R.id.idTxtFinal);
      sekBarra 			= (SeekBar)findViewById(R.id.idSeekBar);
      imgPlayBtn 		= (ImageButton)findViewById(R.id.idImgBtnPlay);
      imgPauseBtn 		= (ImageButton)findViewById(R.id.idImgBtnPause);
      mdpTocador 		= MediaPlayer.create(this, R.raw.backinblack);
      
      sekBarra.setClickable(false);
      imgPauseBtn.setEnabled(false);

   }

   public void play(View view)
   {
		Toast.makeText(getApplicationContext(), "Tocando a Musica", Toast.LENGTH_SHORT).show();
		mdpTocador.start();
		
		dTempoFinal 	= mdpTocador.getDuration();
		dTempoInicial 	= mdpTocador.getCurrentPosition();
		
		if(iApenasUmaVez == 0)
		{
			sekBarra.setMax((int) dTempoFinal);
			iApenasUmaVez = 1;
		} 
		
		txtTempoFinal.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) dTempoFinal),TimeUnit.MILLISECONDS.toSeconds((long) dTempoFinal) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) dTempoFinal))));
		txtTempoInicial.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) dTempoInicial),TimeUnit.MILLISECONDS.toSeconds((long) dTempoInicial) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) dTempoInicial))));
		sekBarra.setProgress((int)dTempoInicial);
		
		hdlHandlerLocal.postDelayed(UpdateSongTime,100);
		imgPauseBtn.setEnabled(true);
		imgPlayBtn.setEnabled(false);
	}

   private Runnable UpdateSongTime = new Runnable() 
   {
      public void run() 
      {
         dTempoInicial = mdpTocador.getCurrentPosition();
         txtTempoInicial.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long) dTempoInicial),TimeUnit.MILLISECONDS.toSeconds((long) dTempoInicial) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) dTempoInicial))));
         sekBarra.setProgress((int)dTempoInicial);
         hdlHandlerLocal.postDelayed(this, 100);
      }
   };
   
   public void pause(View view)
   {
      Toast.makeText(getApplicationContext(), "Musica Pausada", 
      Toast.LENGTH_SHORT).show();

      mdpTocador.pause();
      imgPauseBtn.setEnabled(false);
      imgPlayBtn.setEnabled(true);
   }	
   
   public void forward(View view)
   {
      int temp = (int)dTempoInicial;
      
      if((temp+iTempoAvanco)<=dTempoFinal)
      {
         dTempoInicial = dTempoInicial + iTempoAvanco;
         mdpTocador.seekTo((int) dTempoInicial);
      }
      else
      {
         Toast.makeText(getApplicationContext(), "N‹o Ž poss’vel Avanar 5 Segundos", Toast.LENGTH_SHORT).show();
      }

   }
   
   public void rewind(View view)
   {
      int temp = (int)dTempoInicial;
      if((temp-iTempoVolta)>0)
      {
         dTempoInicial = dTempoInicial - iTempoVolta;
         mdpTocador.seekTo((int) dTempoInicial);
      }
      else
      {
         Toast.makeText(getApplicationContext(),"N‹o Ž poss’vel Retroceder 5 Segundos",Toast.LENGTH_SHORT).show();
      }

   }
 }
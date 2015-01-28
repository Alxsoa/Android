package com.example.camera_01;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	 private static final int MeuRequest = 1001;
	 ImageView imgImagem;
	 
	 private boolean TemCamera () 
	 {
		if (getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) 
			return true;
		else 
			return false;
	 }
 
	 public void onCreate(Bundle savedInstanceState) 
	 {
	     super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         imgImagem = (ImageView) this.findViewById(R.id.idImgImagem);
         Button btnBotao = (Button) this.findViewById(R.id.idBtnBotao);

         btnBotao.setOnClickListener(new View.OnClickListener() 
         {
		     @Override
		     public void onClick(View v) 
		     {	    	 
		 		if (!TemCamera()) 
		 		{
					Toast.makeText(getApplicationContext(),"Aparelho N‹o Suporta Camera",Toast.LENGTH_LONG).show();
					finish();
				}
		 		else
		 		{
					Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
					startActivityForResult(cameraIntent, MeuRequest);
		 		}
	         }
         });
     }

     protected void onActivityResult(int requestCode, int resultCode, Intent data) 
     {
    	 if ( resultCode == RESULT_OK )
    	 {
		      if (requestCode == MeuRequest) 
		      {
		       Bitmap photo = (Bitmap) data.getExtras().get("data");
		       imgImagem.setImageBitmap(photo);
		      }
    	 }
     }
}

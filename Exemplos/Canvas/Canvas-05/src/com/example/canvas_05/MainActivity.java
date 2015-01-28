package com.example.canvas_05;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity 
{
  ImageView imgImagem;

  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    imgImagem = (ImageView) this.findViewById(R.id.idImgImagem);
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rio);
     
    bitmap = Bitmap.createScaledBitmap(bitmap, 854, 480, true);
    imgImagem.setImageBitmap(bitmap);
  }
}

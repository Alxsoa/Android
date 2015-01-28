package com.example.canvas_04;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
    Bitmap bitmap = Bitmap.createBitmap( 200, 200, Bitmap.Config.ARGB_8888);
    
    Canvas canvas = new Canvas(bitmap);
    imgImagem.setImageBitmap(bitmap);

    Paint paint = new Paint();
    paint.setColor(Color.GREEN);
    paint.setStrokeWidth(10);
    canvas.drawLine(0, 0, 200, 200, paint); 
    canvas.drawLine(0, 200, 200, 0, paint); 
    
  }
}

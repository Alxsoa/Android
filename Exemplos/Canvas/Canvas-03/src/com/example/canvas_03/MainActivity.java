package com.example.canvas_03;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity 
{
	Paint paint = new Paint();
	Bitmap bitmapOrg;

	public static Bitmap roundCorner(Bitmap btmImagem, float fRaio) 
	{
	    int iLargura = btmImagem.getWidth();
	    int iAltura = btmImagem.getHeight();
	    
	    Bitmap result = Bitmap.createBitmap(iLargura, iAltura, Config.ARGB_8888);
	    Canvas cnvTela = new Canvas(result);
	    cnvTela.drawARGB(0, 0, 0, 0);
	 
	    final Paint pntPincel = new Paint();
	    pntPincel.setAntiAlias(true);
	    pntPincel.setColor(Color.BLACK);
	 
	    final Rect rctRetangulo = new Rect(0, 0, iLargura, iAltura);
	    final RectF rcfRetangulo = new RectF(rctRetangulo);
	 
	    cnvTela.drawRoundRect(rcfRetangulo, fRaio, fRaio, pntPincel);
	    pntPincel.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	    cnvTela.drawBitmap(btmImagem, rctRetangulo, rctRetangulo, pntPincel);

	    return result;
	}	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(new SampleView(this));
	}
	
	private static class SampleView extends View
	{
		public SampleView(Context context)
		{
			super(context);
			setFocusable(true);
		}
 
		@Override
		protected void onDraw(Canvas canvas) 
		{			
			Paint pntCores = new Paint();
			canvas.drawColor(Color.DKGRAY);
	
			Bitmap btmImagemOriginal = BitmapFactory.decodeResource(getResources(),R.drawable.rio);	
			canvas.drawBitmap (roundCorner(btmImagemOriginal, (float) 30.0), 10, 10, pntCores);
			canvas.drawBitmap (roundCorner(btmImagemOriginal, (float) 100.0), 10, 220, pntCores);
 
		} 
	}
}

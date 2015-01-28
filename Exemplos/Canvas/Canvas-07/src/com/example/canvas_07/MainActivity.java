package com.example.canvas_07;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	Paint paint = new Paint();
	Bitmap bitmapOrg;
	
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
			pntCores.setFilterBitmap(true);
			
			Bitmap btmImagemOriginal = BitmapFactory.decodeResource(getResources(),R.drawable.rio);
			
	 		int iAlturaOriginal  = btmImagemOriginal.getHeight();
			int iLarguraOriginal = btmImagemOriginal.getWidth();
			
			int iAlturaNova  = iAlturaOriginal * 2;
			int iLarguraNova = iLarguraOriginal * 2;
			
			float fEscalaAltura  = ((float) iLarguraNova) / iLarguraOriginal;
			float fEscalaLargura = ((float) iAlturaNova) / iAlturaOriginal;
			
			Matrix matrix = new Matrix();
			matrix.postScale (fEscalaAltura, fEscalaLargura);
			
			Bitmap btmImagemAlterada = Bitmap.createBitmap (btmImagemOriginal, 0, 0,iLarguraOriginal, iAlturaOriginal, matrix, true);
			canvas.drawBitmap (btmImagemOriginal, 10, 10, pntCores);
			canvas.drawBitmap (btmImagemAlterada, 10, 10+iAlturaOriginal+10, pntCores);
 
		}
 
	}
}

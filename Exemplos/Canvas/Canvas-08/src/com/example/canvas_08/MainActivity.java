package com.example.canvas_08;

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

public class MainActivity extends Activity 
{
	Paint paint = new Paint();
	Bitmap bitmapOrg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(new MinhaView(this));
	}
 
	private static class MinhaView extends View
	{
		public MinhaView(Context context)
		{
			super(context);
			setFocusable(true);
		}
 
		@Override
		protected void onDraw(Canvas canvas) 
		{
			Paint pntCores = new Paint();
			canvas.drawColor(Color.DKGRAY);
			Matrix matrix = new Matrix();
			
			
			Bitmap btmImagemOriginal = BitmapFactory.decodeResource(getResources(),R.drawable.rio);
			
	 		int iAlturaOriginal  = btmImagemOriginal.getHeight();
			int iLarguraOriginal = btmImagemOriginal.getWidth();
			
			matrix.reset();
			matrix.postTranslate(-btmImagemOriginal.getWidth() / 2, -btmImagemOriginal.getHeight() / 2); // Centers image
			matrix.postRotate(45);
			matrix.postTranslate(200, 200);
			canvas.drawBitmap(btmImagemOriginal, matrix, null);
 
		}
 
	}
}

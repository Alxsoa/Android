package com.example.canvas_09;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

	public class Desenhar extends View{

		Bitmap bm; 
	   	Paint mPaint;

	   	public Desenhar(Context context) {	super(context);	init();	}
	    public Desenhar(Context context, AttributeSet attrs) { super(context, attrs); init(); }
	    public Desenhar(Context context, AttributeSet attrs, int defStyle) { super(context, attrs, defStyle); init(); }
	 
	    private void init() 
	    {
			bm = BitmapFactory.decodeResource(getResources(), R.drawable.rio);
			mPaint=new Paint();
	    }
	   	
	   	@Override
		protected void onDraw(Canvas canvas)
		{
			super.onDraw(canvas);
			canvas.save();
			mPaint.setColor(Color.RED);
	        canvas.drawBitmap(bm, 20, 50, mPaint);
	        canvas.drawCircle(10, 10, 10, mPaint);
			canvas.restore();
		}   	
	}

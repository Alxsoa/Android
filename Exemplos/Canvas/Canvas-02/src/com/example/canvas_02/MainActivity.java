package com.example.canvas_02;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity 
{
	Paint paint = new Paint();
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
        setContentView(new MinhaView(this));
    }

    public class MinhaView extends View 
    {
    	public MinhaView(Context context) 
        {
    		super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) 
        {
        	super.onDraw(canvas);
        	
            int iLargura = getWidth();
            int iAltura = getHeight();

            paint.setStrokeWidth(6);
            paint.setColor(Color.GREEN);           
            canvas.drawLine(0,0,iLargura, iAltura,paint);
            
            paint.setColor(Color.RED);
            canvas.drawLine(0, iAltura, iLargura, 0, paint);
            
            paint.setStrokeWidth(10);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(0, 0, iLargura, iAltura, paint);

        }
     }
}

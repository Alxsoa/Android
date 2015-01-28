package com.example.canvas_01;

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
            int iRaio;
            iRaio = 100;

            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.parseColor("#B0C4DE"));
            canvas.drawPaint(paint);

            paint.setColor(Color.parseColor("#CD5C5C"));
            canvas.drawCircle(iLargura / 2, iAltura / 4, iRaio, paint);
            
            paint.setColor(Color.BLUE);
            canvas.drawCircle(iLargura / 2, iAltura / 2, iRaio, paint);

        }
     }
}

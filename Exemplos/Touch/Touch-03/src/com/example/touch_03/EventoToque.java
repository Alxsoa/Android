package com.example.touch_03;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

@SuppressLint("ClickableViewAccessibility") 
public class EventoToque extends View 
{
	private Paint pntPincel = new Paint();
	private Path pthWay = new Path();
	private float fPosX;
	private float fPosY;
	private boolean bDown = false;

	public EventoToque(Context context, AttributeSet attrs) 
	{
		super(context, attrs);

		pntPincel.setAntiAlias(true);
        pntPincel.setColor(Color.parseColor("#B0C4DE"));
		pntPincel.setStrokeWidth(6f);
		pntPincel.setStyle(Paint.Style.STROKE);
		pntPincel.setStrokeJoin(Paint.Join.ROUND);
	}

	@Override
	protected void onDraw(Canvas canvas) 
	{
		canvas.drawPath(pthWay, pntPincel);
		if (bDown) 
		{
			canvas.drawCircle(fPosX, fPosY, 20, pntPincel);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) 
	{
		fPosX = event.getX();
		fPosY = event.getY();

		switch (event.getAction()) 
		{
			case 	MotionEvent.ACTION_DOWN:
					bDown = true;
					pthWay.moveTo(fPosX, fPosY);
					invalidate();
					return true;
			
			case 	MotionEvent.ACTION_MOVE:
					pthWay.lineTo(fPosX, fPosY);
					invalidate();
					break;
				
			case 	MotionEvent.ACTION_UP:
					bDown = false;
					invalidate();
					break;
				
			default:
				return false;
		}
		return true;
	}
}
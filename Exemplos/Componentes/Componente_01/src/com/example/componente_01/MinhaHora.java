package com.example.componente_01;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

public class MinhaHora extends TextView 
{
	private String strMsg;
	private boolean bCor;
	   
	public MinhaHora(Context context) 
	{
		super(context);
		setTimeView();
	}

	public MinhaHora(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MinhaHora);
	    int count = typedArray.getIndexCount();
	    
	    try
	    {
		    for (int i = 0; i < count; ++i) 
		    {
		    	int attr = typedArray.getIndex(i);
		    	if(attr == R.styleable.MinhaHora_texto) 
		    	{
		    		strMsg = typedArray.getString(attr);
	    	     	setTimeView();
		    	} 
		    	else 
		    		if(attr == R.styleable.MinhaHora_cor) 
		    		{
			    		bCor = typedArray.getBoolean(attr, false);
			    		decorateText();
		    		}
		    }
	    } 

	    finally 
	    {
	    	typedArray.recycle();
	    }
	}

	public MinhaHora(Context context, AttributeSet attrs, int defStyle) 
	{
	      super(context, attrs, defStyle);
	      setTimeView();
	}
	
	private void setTimeView() 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
		String time = dateFormat.format(Calendar.getInstance().getTime());
		
		if(this.strMsg != null )
			setText(this.strMsg+" "+time);
		else 
			setText(time);
	}
	
	private void decorateText() 
	{
		if(this.bCor == true)
		{
	    	setShadowLayer(4, 2, 2, Color.rgb(250, 00, 250));
	    	setBackgroundColor(Color.CYAN);
		} 
		else 
		{
			setBackgroundColor(Color.RED);
		}
	}
}


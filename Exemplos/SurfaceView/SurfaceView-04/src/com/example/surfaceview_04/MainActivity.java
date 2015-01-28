package com.example.surfaceview_04;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class MainActivity extends Activity 
{
	private ViewFlipper vwfFlipper;
    private float fPosicaoX;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	vwfFlipper = (ViewFlipper) findViewById(R.id.idFlipper);
    } 
                
    public boolean onTouchEvent(MotionEvent touchevent) 
    {
    	switch (touchevent.getAction())
    	{
	    	case MotionEvent.ACTION_DOWN: 
	    	{
	    		fPosicaoX = touchevent.getX();
	    		break;
	    	}
	    	case MotionEvent.ACTION_UP: 
	    	{
	    		float fPosicaoAtualX = touchevent.getX();
	    				
	    		if (fPosicaoX < fPosicaoAtualX) 
	    		{
	    			if (vwfFlipper.getDisplayedChild() == 0)
	    			{
	    				break;
	    			}
 
	    			vwfFlipper.setInAnimation(this, R.anim.da_direita);
	    			vwfFlipper.setOutAnimation(this, R.anim.para_direita);
	    			vwfFlipper.showNext();
	    		}
	                             
	    		if (fPosicaoX > fPosicaoAtualX)
	    		{
	    			if (vwfFlipper.getDisplayedChild() == 1)
	    			{
	    				break;
	    			}
	    			
	    			vwfFlipper.setInAnimation(this, R.anim.da_esquerda);
	    			vwfFlipper.setOutAnimation(this, R.anim.para_esquerda);
	    			vwfFlipper.showPrevious();
	    		}
	    		break;
	    	}
    	}
    	return false;
    }

}
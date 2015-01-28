package com.example.viewflipper_02;

import android.os.Bundle;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class MainActivity extends Activity 
{
    private ViewFlipper viewFlipper;
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.view_flipper_main);
         viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
    }  
                        
    public boolean onTouchEvent(MotionEvent touchevent) 
    {
	     switch (touchevent.getAction())
	     {
			 case MotionEvent.ACTION_DOWN: 
			 {
			     lastX = touchevent.getX();
			     break;
			 }
			 
             case MotionEvent.ACTION_UP: 
             {
                 float currentX = touchevent.getX();
                 if (lastX < currentX) 
                 {
                     if (viewFlipper.getDisplayedChild() == 0)
                         break;

                     viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
                     viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
                     viewFlipper.showNext();
                 }
                 
                 if (lastX > currentX)
                 {
                     if (viewFlipper.getDisplayedChild() == 1)
                         break;
                     
                     viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
                     viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
                     viewFlipper.showPrevious();
                 }
                 break;
             }
	     }
	     return false;
    }
 }

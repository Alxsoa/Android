package com.wglxy.demo.rotate;

import com.wglxy.demo.rotate.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * This is main activity for this demo app.
 */

public class MainActivity extends FragmentActivity {

    public int mRotation = 0;
    public float mScale = 1.0f;
    public int mScaleNum = 0, mOffsetsNum;

    public float [] mScaleVals = {1.0f, 0.5f, 0.25f};
    public float [] mOffsets = {0f, 0.25f, 0.50f, 0.75f};       // offsets are based on width and height of the view

/**
 * onCreate
 */

@Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    StarshipView sv = (StarshipView) findViewById (R.id.ship1);
    if (sv != null) {
       sv.setBitmapFromResource (R.drawable.starship1);
       sv.setScale (1.0f);
       sv.invalidate ();
    }

    StarshipView sv2 = (StarshipView) findViewById (R.id.ship2);
    if (sv2 != null) {
       sv2.setBitmapFromResource (R.drawable.starship2);
       sv2.setScale (1.0f);
       sv.invalidate ();
    }
}

/**
 * Handle the click on a button.
 *
 */

public void onClick (View v) {

    StarshipView sv = (StarshipView) findViewById (R.id.ship1);
    StarshipView sv2 = (StarshipView) findViewById (R.id.ship2);

    float newScale1 = 1.0f, newScale2 = 1.0f;
    float newOffset1 = 0f, newOffset2 = 0f;
    int degrees1 = (sv == null) ? 0 : sv.getDegrees ();
    int degrees2 = (sv2 == null) ? 0 : sv2.getDegrees ();
    newScale1 = (sv == null) ? 1f : sv.getScale ();
    newScale2 = (sv2 == null) ? 1f : sv2.getScale ();
    newOffset1 = (sv == null) ? 1f : sv.getOffsetX ();
    newOffset2 = (sv2 == null) ? 1f : sv2.getOffsetX ();

    int vid = v.getId ();
    switch (vid) {
      case R.id.rotate_button : 
        degrees1 += 10;
        degrees2 += 10;
        break;

      case R.id.scale_button : 
        mScaleNum++;
        if (mScaleNum >= mScaleVals.length) mScaleNum = 0;
        newScale1 = newScale2 = mScaleVals [mScaleNum];
        break;

      case R.id.offset_button : 
        mOffsetsNum++;
        if (mOffsetsNum >= mOffsets.length) mOffsetsNum = 0;
        newOffset1 = mOffsets [mOffsetsNum] * (float) sv.getWidth ();
        newOffset2 = mOffsets [mOffsetsNum] * (float) sv2.getWidth ();
        break;


    }
    if (sv != null) {
       sv.setScale (newScale1);
       sv.setDegrees (degrees1);
       sv.setOffsetX (newOffset1);
       sv.setOffsetY (newOffset1);
       sv.invalidate ();
    }

    if (sv2 != null) {
       sv2.setScale (newScale2);
       sv2.setDegrees (degrees2);
       sv2.setOffsetX (newOffset2);
       sv2.setOffsetY (newOffset2);
       sv2.invalidate ();
    }

}

/**
 * Handle the click on a view.
 *
 * If the StarshipView is clicked, its orientation changes by a few degrees.
 *
 */

public void onClickView (View v) {

    int vid = v.getId ();
    switch (vid) {
      case R.id.ship1 : 
        StarshipView sv2 = (StarshipView) findViewById (R.id.ship2);
        if (sv2 != null) {
           sv2.setDegrees (sv2.getDegrees () + 10);
           sv2.invalidate ();
        }
      case R.id.ship2 : 
          StarshipView sv = (StarshipView) v;
          sv.setDegrees (sv.getDegrees () + 10);
          sv.invalidate ();
          break;
    }
}


}

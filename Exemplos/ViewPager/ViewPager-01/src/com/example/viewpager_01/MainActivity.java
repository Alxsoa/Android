package com.example.viewpager_01;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class MainActivity extends Activity 
{
	private int[] iImgLogo =	{
									R.drawable.hp_logo_1,
									R.drawable.hp_logo_2,
									R.drawable.hp_logo_3,
									R.drawable.hp_logo_4,
									R.drawable.hp_logo_5,
									R.drawable.hp_logo_6,
									R.drawable.hp_logo_7
								};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewPager vp = (ViewPager) findViewById(R.id.viewPager);
		vp.setAdapter (new AdapterImg(this, iImgLogo));		
	}

}

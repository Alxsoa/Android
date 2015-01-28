package com.example.viewpager_02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;


public class MainActivity extends FragmentActivity 
{
	ViewPager viewPager = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewPager = (ViewPager) findViewById (R.id.pager);
		FragmentManager fragmentManager=getSupportFragmentManager();
		viewPager.setAdapter (new MyAdapter(fragmentManager));
	}
	
	class MyAdapter extends FragmentPagerAdapter
	{
		public MyAdapter(FragmentManager fm) 
		{
			super(fm);
		}

		@Override
		public Fragment getItem (int i) 
		{
			Fragment fragment = null;
			if (i==0)
			{
				fragment=new FragmentA();
			}
			
			if (i==1)
			{
				fragment=new FragmentB();
			}
			
			if (i==2)
			{
				fragment=new FragmentC();
			}
			return fragment;
			
		}
		
		@Override
		public int getCount ()
		{
			return 3;
		}
	}
}

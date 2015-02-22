package com.example.rlistview_05;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.example.listview_05.AndroidListViewActivity;
import com.example.listview_05.R;
import com.robotium.solo.Solo;

public class TestMain extends ActivityInstrumentationTestCase2<AndroidListViewActivity> 
{
	private Solo solo;
	
	public TestMain() 
	{
		super(AndroidListViewActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testDisplayWhiteBox() 
	{
		solo.clickInList(5);
		TextView txtMeses = (TextView) solo.getView(R.id.meses);		
		assertEquals("31 Dias", txtMeses.getText().toString());
		solo.sleep(1000);		
		solo.goBack();
		//solo.takeScreenshot();
	}
	
	@Override
	protected void tearDown() throws Exception
	{
			solo.finishOpenedActivities();
	}
}
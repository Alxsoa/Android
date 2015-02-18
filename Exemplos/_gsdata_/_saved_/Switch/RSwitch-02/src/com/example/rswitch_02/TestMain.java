package com.example.rswitch_02;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.example.switch_02.MainActivity;
import com.example.switch_02.R;
import com.robotium.solo.Solo;

public class TestMain extends ActivityInstrumentationTestCase2<MainActivity> 
{
	private Solo solo;
	MainActivity dtcAtividade;
	
	public TestMain() 
	{
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
		dtcAtividade = getActivity();
	}
	
	public void testDisplayWhiteBox() 
	{
		solo.sleep (1000);		
		solo.clickOnText("Flash"); 
		assertTrue(solo.waitForText("Mudou o Estado do Switch"));
		//solo.takeScreenshot();
	}
	
	@Override
	protected void tearDown() throws Exception
	{
			solo.finishOpenedActivities();
	}
}
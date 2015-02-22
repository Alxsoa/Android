package com.example.rlistview_02;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import com.example.listview_02.MainActivity;
import com.example.listview_02.R;
import com.robotium.solo.Solo;

public class TestMain extends ActivityInstrumentationTestCase2<MainActivity> 
{
	private Solo solo;
	
	public TestMain() 
	{
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testDisplayWhiteBox() 
	{
		//solo.clickOnButton("Alerta com uma Lista");
		solo.clickInList(3);
		assertTrue(solo.waitForText("A Plataforma Selecionada Foi Windows Mobile"));
		//solo.takeScreenshot();
	}
	
	@Override
	protected void tearDown() throws Exception
	{
			solo.finishOpenedActivities();
	}
}
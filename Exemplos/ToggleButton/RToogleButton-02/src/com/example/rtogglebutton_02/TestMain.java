package com.example.rtogglebutton_02;

import android.test.ActivityInstrumentationTestCase2;
import com.example.togglebutton_02.MainActivity;
import com.example.togglebutton_02.R;
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
		boolean actual = solo.isToggleButtonChecked(0);
		solo.clickOnToggleButton("Flash Ligado");
		if ( !actual )
		{
			assertEquals("Mudou o Estado do Toggle",true, actual);
		}
		//solo.takeScreenshot();
	}
	
	@Override
	protected void tearDown() throws Exception
	{
			solo.finishOpenedActivities();
	}
}
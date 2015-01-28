package com.example.rcheckbox_01;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.CheckBox;
import com.robotium.solo.Solo;
import com.example.checkbox_01.R;
import com.example.checkbox_01.MainActivity;;

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
		
		CheckBox chkAndroid = (CheckBox) solo.getView(R.id.chkAndroid);
		solo.clickOnText("Android");
		solo.clickOnButton("Escolha uma Opção");
		//solo.takeScreenshot();
	}
	
	@Override
	protected void tearDown() throws Exception
	{
			solo.finishOpenedActivities();
	}
}
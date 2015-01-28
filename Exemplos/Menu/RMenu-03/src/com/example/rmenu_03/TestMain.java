package com.example.rmenu_03;

import android.test.ActivityInstrumentationTestCase2;
import com.example.menu_03.MainActivity;
import com.example.menu_03.R;
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
		solo.clickOnMenuItem("Ação 3");
		solo.sleep (1000);
		solo.clickOnMenuItem("Ação 3 - Opção #2");
		solo.sleep (1000);
		//assertTrue(solo.waitForText("A Senha Digita Foi MinhaSenha"));
		
		dtcAtividade.finish();
		//solo.takeScreenshot();
	}
	
	@Override
	protected void tearDown() throws Exception
	{
			solo.finishOpenedActivities();
	}
}
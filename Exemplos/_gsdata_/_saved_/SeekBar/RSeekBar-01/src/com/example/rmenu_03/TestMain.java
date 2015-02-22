package com.example.rmenu_03;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.seekbar_01.MainActivity;
import com.example.seekbar_01.R;
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
		TextView txtOutMsg;
		boolean bAtual;
		
		solo.sleep (1000);
		solo.setProgressBar(0, 10);
		
		bAtual = solo.searchText("O Valor Atual Ž");
		assertEquals("10",true, bAtual);
		
		solo.sleep (1000);
		solo.setProgressBar(0, 90);
		bAtual = solo.searchText("O Valor Atual Ž");
		assertEquals("90",true, bAtual);
		
		dtcAtividade.finish();
		//solo.takeScreenshot();
	}
	
	@Override
	protected void tearDown() throws Exception
	{
			solo.finishOpenedActivities();
	}
}
package com.example.rmultijanela_02;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.multijanela_02.PrimeiraJanelaActivity;
import com.example.multijanela_02.R;
import com.example.multijanela_02.SegundaJanela;
import com.robotium.solo.Solo;

public class TestMain extends ActivityInstrumentationTestCase2<PrimeiraJanelaActivity> 
{
	private Solo solo;
	PrimeiraJanelaActivity dtcAtividade;
	SegundaJanela dtcAtividade2;
	
	public TestMain() 
	{
		super(PrimeiraJanelaActivity.class);
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
	    if (solo.waitForActivity(PrimeiraJanelaActivity.class)) 
	    {
	    	System.out.println("Activity Atual = "+solo.getCurrentActivity().getLocalClassName());
			solo.clickOnButton("Iniciar");
	        if (solo.waitForActivity(SegundaJanela.class)) 
	        {
		    	System.out.println("Activity Atual = "+solo.getCurrentActivity().getLocalClassName());
	    		TextView txtSecundario = (TextView) solo.getView(R.id.txtSecundario);		
		    	assertEquals(" Janela Principal", txtSecundario.getText().toString());
				solo.clickOnButton("Voltar");
	        }
	        
	    	System.out.println("Activity Atual = "+solo.getCurrentActivity().getLocalClassName());
    		TextView txtPrimario = (TextView) solo.getView(R.id.txtPrimario);		
	    	assertEquals(" Janela Secundaria", txtPrimario.getText().toString());
			solo.clickOnButton("Sair");
	    }
		
		//solo.takeScreenshot();
	}
	
	@Override
	protected void tearDown() throws Exception
	{
			solo.finishOpenedActivities();
	}
}
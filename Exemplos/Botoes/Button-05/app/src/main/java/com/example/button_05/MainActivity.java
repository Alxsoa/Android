package com.example.button_05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity 
{
	Button btnBotao_01;
	Button btnBotao_02;
	Button btnBotao_03;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnBotao_01 = (Button) findViewById(R.id.idBtn01);
		btnBotao_02 = (Button) findViewById(R.id.idBtn02);
		btnBotao_03 = (Button) findViewById(R.id.idBtn03);
	}

    public void btnClickProcessing_01(View view)
    {
        btnBotao_02.setEnabled(false);
        btnBotao_03.setEnabled(false);

        Toast tstMsg = Toast.makeText ( getBaseContext(),
                                        "Clicado o Primeiro Botao",
                                        Toast.LENGTH_LONG);
        tstMsg.show();
    }

    public void btnClickProcessing_02(View view)
    {
        btnBotao_01.setEnabled(false);
        btnBotao_03.setEnabled(false);

        Toast tstMsg = Toast.makeText ( getBaseContext(),
                                        "Clicado o Segundo Botao",
                                        Toast.LENGTH_LONG);
        tstMsg.show();
    }

    public void btnClickProcessing_03(View view)
    {
        btnBotao_01.setEnabled(false);
        btnBotao_02.setEnabled(false);

        Toast tstMsg = Toast.makeText ( getBaseContext(),
                "Clicado o Terceiro Botao",
                Toast.LENGTH_LONG);
        tstMsg.show();
    }
}
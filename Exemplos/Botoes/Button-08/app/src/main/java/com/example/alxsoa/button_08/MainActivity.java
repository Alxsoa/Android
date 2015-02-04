package com.example.alxsoa.button_08;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity
{
    Button btnBotao_01;
    Button btnBotao_02;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SomaListenerParaBotoes();
    }

    public void SomaListenerParaBotoes()
    {
        btnBotao_01 = (Button) findViewById(R.id.idBtn1);
        btnBotao_01.setOnClickListener(Processa_Botao_01);

        btnBotao_02 = (Button) findViewById(R.id.idBtn2);
        btnBotao_02.setOnClickListener(Processa_Botao_02);
    }

    View.OnClickListener Processa_Botao_01 = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Toast tstMsg = Toast.makeText ( getBaseContext(),
                    "Clicado o Primeiro Botao",
                    Toast.LENGTH_LONG);
            tstMsg.show();
        }
    };

    View.OnClickListener Processa_Botao_02 = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Toast tstMsg = Toast.makeText ( getBaseContext(),
                    "Clicado o Segundo Botao",
                    Toast.LENGTH_LONG);
            tstMsg.show();
        }
    };
}
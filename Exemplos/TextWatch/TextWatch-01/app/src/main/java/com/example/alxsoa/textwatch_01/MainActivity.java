package com.example.alxsoa.textwatch_01;

//
// http://www.learn2crack.com/2014/02/android-textwatcher-example.html
//

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    EditText edtCoisas;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCoisas = (EditText)findViewById(R.id.IdedtCoisas);
        lblResultado = (TextView)findViewById(R.id.IdlblResultado);
        edtCoisas.addTextChangedListener(MonitoraText);
    }

    TextWatcher MonitoraText = new TextWatcher()
    {

        @Override
        public void afterTextChanged(Editable arg0)
        {
        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3)
        {
        }

        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c)
        {
            lblResultado.setText(s);
            if(a == 8)
            {
                Toast.makeText (    getApplicationContext(),
                                    "Limite Teórico Alcançado",
                                    Toast.LENGTH_SHORT).show();
            }
        }
    };
}

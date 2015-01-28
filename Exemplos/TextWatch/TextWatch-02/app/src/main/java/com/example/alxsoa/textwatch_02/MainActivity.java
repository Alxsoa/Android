package com.example.alxsoa.textwatch_02;


//
// http://www.learn2crack.com/2014/02/android-textwatcher-example.html
// http://developer.android.com/reference/android/text/TextWatcher.html
// http://developer.android.com/reference/java/lang/CharSequence.html
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
            // afterTextChanged : The same as above, except now the text is editable.
            // This event is used when you need to see and possibly edit new text.

            String s=arg0.toString();
            if(!s.equals(s.toUpperCase()))
            {
                s=s.toUpperCase();
                lblResultado.setText(s);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence csString, int iStart, int iCount, int iAfter)
        {
           // beforeTextChanged : This means that the characters are about to be replaced
           // with some new text. The text is uneditable. This event is used when you need
           // to take a look at the old text which is about to change.
        }

        @Override
        public void onTextChanged(CharSequence sString, int iStart, int iBefore, int iCount)
        {
            // onTextChanged: Changes have been made, some characters have just been
            // replaced. The text is uneditable. This event is used when you need to see
            // which characters in the text are new.

            lblResultado.setText(sString);
            if(iStart == 9)
            {
                Toast.makeText ( getApplicationContext(),
                                 "Limite Teórico Alcançado",
                                 Toast.LENGTH_SHORT).show();
            }
        }
    };
}

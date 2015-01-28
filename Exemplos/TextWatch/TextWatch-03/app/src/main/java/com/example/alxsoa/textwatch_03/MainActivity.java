package com.example.alxsoa.textwatch_03;

//
// http://www.learn-android-easily.com/2013/06/using-textwatcher-in-android.html
//

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.text.Editable;

public class MainActivity extends Activity
{
    EditText editTextPassword;
    TextView textViewPasswordStrengthIndiactor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        textViewPasswordStrengthIndiactor=(TextView)findViewById(R.id.textViewPasswordStrength);

        editTextPassword.addTextChangedListener(mTextEditorWatcher);

    }

    private final TextWatcher  mTextEditorWatcher = new TextWatcher()
    {

        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
            textViewPasswordStrengthIndiactor.setText("Não Definida");
        }

        public void onTextChanged(CharSequence s, int start, int before, int count)
        {

        }

        public void afterTextChanged(Editable s)
        {
            if(s.length()==0)
                textViewPasswordStrengthIndiactor.setText("Não Definida");
            else if(s.length()<6)
                textViewPasswordStrengthIndiactor.setText("Fácil");
            else if(s.length()<10)
                textViewPasswordStrengthIndiactor.setText("Moderada");
            else if(s.length()<15)
                textViewPasswordStrengthIndiactor.setText("Difícil");
            else
                textViewPasswordStrengthIndiactor.setText("Muito Difícil");

            if(s.length()==20)
                textViewPasswordStrengthIndiactor.setText("Limite da Senha Alcançado");
        }
    };

}

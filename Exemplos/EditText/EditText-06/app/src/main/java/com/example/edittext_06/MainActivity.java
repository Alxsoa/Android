package com.example.edittext_06;

import android.os.Bundle;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EditText txtTexto = (EditText)findViewById(R.id.idText);
        txtTexto.setInputType (	android.text.InputType.TYPE_CLASS_TEXT | 
        						android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    }    
}

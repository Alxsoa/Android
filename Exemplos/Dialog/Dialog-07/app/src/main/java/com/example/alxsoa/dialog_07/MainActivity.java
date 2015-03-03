package com.example.alxsoa.dialog_07;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    EditText etRetorno;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRetorno = (EditText) findViewById(R.id.etRetorno);
    }

    //Método executado quando usuário clicar no botão
    //Chamar Dialog
    public void ChamarDialog_click(View v){
        ExibeDialog();
    }

    private void ExibeDialog(){
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.customdialog);

        //define o título do Dialog
        dialog.setTitle("Busca de cliente:");

        //instancia os objetos que estão no layout customdialog.xml
        final Button confirmar = (Button) dialog.findViewById(R.id.btn_Confirmar);
        final Button cancelar = (Button) dialog.findViewById(R.id.btn_Cancelar);
        final EditText editText = (EditText) dialog.findViewById(R.id.etValor);
        final TextView tvMens = (TextView) dialog.findViewById(R.id.tvMens);

        tvMens.setText("Nome");

        confirmar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                etRetorno.setText(editText.getText());

                //finaliza o dialog
                dialog.dismiss();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //finaliza o dialog
                dialog.dismiss();
            }
        });

        //exibe na tela o dialog
        dialog.show();

    }
}
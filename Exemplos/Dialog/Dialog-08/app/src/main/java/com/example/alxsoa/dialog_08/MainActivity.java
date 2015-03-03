package com.example.alxsoa.dialog_08;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    EditText etSearch;
    Button btn, btnSearch, btnCancel;
    Dialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    protected void showCustomDialog() {

        dialog = new Dialog(MainActivity.this,
                android.R.style.Theme_Translucent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog);

        etSearch = (EditText) dialog.findViewById(R.id.etsearch);
        btnSearch = (Button) dialog.findViewById(R.id.btnsearch);
        btnCancel = (Button) dialog.findViewById(R.id.btncancel);

        btnSearch.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                showCustomDialog();
                break;
            case R.id.btnsearch:
                String search = etSearch.getText().toString().trim();
                if (TextUtils.isEmpty(search)) {
                    Toast.makeText(MainActivity.this,
                            "Searching for Nothing",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            "Searching for " + search,
                            Toast.LENGTH_LONG).show();
                }

                dialog.dismiss();
                break;
            case R.id.btncancel:
                dialog.dismiss();
                break;
            default:
                break;
        }

    }
}
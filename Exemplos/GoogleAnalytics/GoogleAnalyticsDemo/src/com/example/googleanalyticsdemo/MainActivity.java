package com.example.googleanalyticsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSaldo = (Button)findViewById(R.id.button);
        btnSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyTracker easyTracker = EasyTracker.getInstance(MainActivity.this);
                easyTracker.send(MapBuilder.createEvent("Menu", "Saldo", "Saldo", null).build());

                Intent itn = new Intent(MainActivity.this, SaldoActivity.class);
                startActivity(itn);
            }
        });

        Button btnExtrato = (Button)findViewById(R.id.button2);
        btnExtrato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyTracker easyTracker = EasyTracker.getInstance(MainActivity.this);
                easyTracker.send(MapBuilder.createEvent("Menu", "Extrato", "Extrato", null).build());

                Intent itn = new Intent(MainActivity.this, ExtratoActivity.class);
                startActivity(itn);
            }
        });

        Button btnTransferencia = (Button)findViewById(R.id.button3);
        btnTransferencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyTracker easyTracker = EasyTracker.getInstance(MainActivity.this);
                easyTracker.send(MapBuilder.createEvent("Menu", "Transferencia", "Transferencia", null).build());

                Intent itn = new Intent(MainActivity.this, TransferenciaActivity.class);
                startActivity(itn);
            }
        });

        Button btnAgendamentos = (Button)findViewById(R.id.button4);
        btnAgendamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyTracker easyTracker = EasyTracker.getInstance(MainActivity.this);
                easyTracker.send(MapBuilder.createEvent("Menu", "Agendamentos", "Agendamentos", null).build());

                Intent itn = new Intent(MainActivity.this, AgendamentosActivity.class);
                startActivity(itn);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        EasyTracker.getInstance(this).activityStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        EasyTracker.getInstance(this).activityStop(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

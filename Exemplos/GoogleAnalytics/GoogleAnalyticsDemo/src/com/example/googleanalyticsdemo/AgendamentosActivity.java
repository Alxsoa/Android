package com.example.googleanalyticsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.google.analytics.tracking.android.EasyTracker;

import java.lang.Override;

/**
 * Created by HP on 13/12/13.
 */
public class AgendamentosActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentos);
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

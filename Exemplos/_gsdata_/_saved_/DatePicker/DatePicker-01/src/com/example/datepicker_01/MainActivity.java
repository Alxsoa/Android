package com.example.datepicker_01;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	private TextView mDateDisplay;
	private Button mPickDate;

	private int mYear;
	private int mMonth;
	private int mDay;

	static final int DATE_DIALOG_ID = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);

        mPickDate.setOnClickListener(new View.OnClickListener() 
        {
            @SuppressWarnings("deprecation")
			public void onClick(View v) 
            {
                showDialog(DATE_DIALOG_ID);
            }
        });

        final Calendar c = Calendar.getInstance();
        mYear 	= c.get(Calendar.YEAR);
        mMonth 	= c.get(Calendar.MONTH);
        mDay 	= c.get(Calendar.DAY_OF_MONTH);

        updateDisplay();
    }
	
    @Override
    protected Dialog onCreateDialog(int id) 
    {
	    switch (id) 
	    {
		    case 	DATE_DIALOG_ID:
			        return new DatePickerDialog(this,mDateSetListener,mYear, mMonth, mDay);
	    }
	    return null;
	}
	
    private void updateDisplay() 
    {
        mDateDisplay.setText(	new StringBuilder()
                    			.append(mMonth + 1).append("-")
                    			.append(mDay).append("-")
                    			.append(mYear).append(" "));
    }
	
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() 
    {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) 
        {
            mYear 	= year;
            mMonth 	= monthOfYear;
            mDay 	= dayOfMonth;
            updateDisplay();
        }
    };
}
package com.example.viewcode_01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class wndSegunda extends Activity {
	//variable for holding select color;
	private String color = "#ff0000";
	//intent for use when returning to main activity
	Intent selectedColor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segunda_main);
		//get our Radio Button Group
		RadioGroup colors = (RadioGroup) findViewById(R.id.radioGroupColors);
		//get our OK Button
		Button ok = (Button) findViewById(R.id.buttonOk);
		//create new selectedColor Intent
		selectedColor = new Intent();
		//set action listener for RadioButton Checked Changed
		colors.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				//set color according to selected RadioButton
				switch (checkedId) {
				case R.id.radioRed:
					color = "#ff0000";
					break;
				case R.id.radioBlue:
					color = "#0000ff";
					break;
				case R.id.radioGreen:
					color = "#00ff00";
					break;
				case R.id.radioBrown:
					color = "#a52a2a";
					break;
				case R.id.radioYellow:
					color = "#ffff00";
					break;
				}

			}
		});
		//set action listener for Ok Button
		ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*set Our selected color value in selectedColor intent with selectedColor key,
				 this is using for getting color from result in main activity*/
				selectedColor.putExtra("selectedColor", color);
				//set result with our selectedColor intent and RESULT_OK request code
				setResult(RESULT_OK, selectedColor);
				//then finish the activity
				finish();
			}
		});
	}

}

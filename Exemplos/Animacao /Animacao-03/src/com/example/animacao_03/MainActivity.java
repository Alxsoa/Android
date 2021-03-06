package com.example.animacao_03;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements AnimationListener 
{
	TextView txtMessage;
	Button btnStart;
	Animation animFadeOut;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fadeout);

		txtMessage = (TextView) findViewById(R.id.txtMessage);
		btnStart = (Button) findViewById(R.id.btnStart);

		animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
		animFadeOut.setAnimationListener(this);

		btnStart.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				txtMessage.startAnimation(animFadeOut);
			}
		});

	}

	@Override
	public void onAnimationEnd(Animation animation) 
	{
		if (animation == animFadeOut) 
		{
			Toast.makeText(getApplicationContext(), "Animacao Terminada", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onAnimationRepeat(Animation animation) 
	{
	}

	@Override
	public void onAnimationStart(Animation animation) 
	{
	}

}
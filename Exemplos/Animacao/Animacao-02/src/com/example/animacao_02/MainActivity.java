package com.example.animacao_02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements AnimationListener 
{

	TextView txtMessage;
	Button btnStart;
	Animation animFadein;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fadein);

		txtMessage = (TextView) findViewById(R.id.txtMessage);
		btnStart = (Button) findViewById(R.id.btnStart);

		animFadein = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
		animFadein.setAnimationListener(this);

		btnStart.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				txtMessage.setVisibility(View.VISIBLE);
				txtMessage.startAnimation(animFadein);
			}
		});

	}

	public void onAnimationEnd(Animation animation) 
	{
		if (animation == animFadein) 
		{
			Toast.makeText(getApplicationContext(), "Animacao Terminada", Toast.LENGTH_SHORT).show();
		}

	}

	public void onAnimationRepeat(Animation animation) 
	{
	}

	public void onAnimationStart(Animation animation) 
	{
	}
}

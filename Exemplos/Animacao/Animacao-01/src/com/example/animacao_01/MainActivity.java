package com.example.animacao_01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity implements AnimationListener 
{
	ImageView 	imgLogo;
	Button 		btnStart;
	Animation 	anmMove;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_move);

		imgLogo  = (ImageView) findViewById(R.id.idImgLogo);
		btnStart = (Button) findViewById(R.id.idBtnStart);

		anmMove = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
		anmMove.setAnimationListener(this);

		btnStart.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				imgLogo.startAnimation(anmMove);
			}
		});
	}

	@Override
	public void onAnimationEnd(Animation animation) 
	{
		if (animation == anmMove) 
		{
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

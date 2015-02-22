package com.example.animacao_13;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MainActivity extends Activity 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button btnBotao1 = (Button) findViewById(R.id.idBotao1);
        btnBotao1.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				RotateAnimation rttAnimacao = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
				rttAnimacao.setDuration(500);
				rttAnimacao.setRepeatCount(2);
				btnBotao1.startAnimation(rttAnimacao);				
			}
		});
        
        final Button btnBotao2 = (Button) findViewById(R.id.idBotao2);
        btnBotao2.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				AnimationSet anmRoteiro = new AnimationSet(true);
				
				RotateAnimation rttAnimacao = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
				rttAnimacao.setDuration(500);
				rttAnimacao.setRepeatCount(2);
				anmRoteiro.addAnimation(rttAnimacao);
				
				TranslateAnimation translateAnimation = new TranslateAnimation(0, 400, 0, 0);
				translateAnimation.setStartOffset(500);
				translateAnimation.setDuration(1000);
				anmRoteiro.addAnimation(translateAnimation);
				
				AlphaAnimation alpAnimacao = new AlphaAnimation(1, 0);
				alpAnimacao.setStartOffset(500);
				alpAnimacao.setDuration(1000);
				anmRoteiro.addAnimation(alpAnimacao);
				btnBotao2.startAnimation(anmRoteiro);
			}
		});
        
        final Button btnBotao3 = (Button) findViewById(R.id.idBotao3);
        btnBotao3.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View v) 
			{
				btnBotao3.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.efeito));
			}
		});

        //LinearLayout mainContainer = (LinearLayout) findViewById(R.id.idLayout);
        //LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.principal);
        //mainContainer.setLayoutAnimation(controller);        
    }
}

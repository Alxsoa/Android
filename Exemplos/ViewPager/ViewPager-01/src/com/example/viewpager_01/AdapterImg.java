package com.example.viewpager_01;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AdapterImg extends PagerAdapter 
{
	private Context context;
	private int[] imgs;
	
	public AdapterImg(Context context, int[] iImgLogos)
	{
		this.context = context;
		this.imgs = iImgLogos;
	}
	
	@Override
	public int getCount() 
	{
		return imgs.length; //Tamanho da lista
	}

	@Override
	public boolean isViewFromObject(View view, Object obj) 
	{
		return view == obj;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int iPosicao)
	{
		
		LinearLayout lnlMeuLayout = new LinearLayout(context);
		lnlMeuLayout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams lnlParametros = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		lnlMeuLayout.setLayoutParams(lnlParametros);
		container.addView(lnlMeuLayout);
		
		ImageView igvImagem = new ImageView(context);
		igvImagem.setImageResource(imgs[iPosicao]);
		lnlMeuLayout.addView(igvImagem);
		
		return(lnlMeuLayout);
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object view)
	{
		container.removeView((View)view);
	}
	
}

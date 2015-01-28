package com.example.componente_02;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MinhaFoto extends ImageView 
{
   
	public MinhaFoto(Context context) 
	{
		super(context);
		ColocaImagem("rio", 470, 320);
	}

	public MinhaFoto(Context context, AttributeSet attrs) 
	{
		super(context, attrs);   
	    String strLocal = null;
	    int iLargura = 0;
	    int iAltura = 0;
	    
		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MinhaFoto);
	    int iTamanho = typedArray.getIndexCount();
	    
	    try
	    {
		    for (int i = 0; i < iTamanho; ++i) 
		    {
		    	int iAtributo = typedArray.getIndex(i);
		    	if(iAtributo == R.styleable.MinhaFoto_local) 
		    	{
			    	strLocal = typedArray.getString(iAtributo);	
		    	}
		    	else
			    	if(iAtributo == R.styleable.MinhaFoto_Largura) 
			    	{
				    	iLargura = typedArray.getInteger(iAtributo, 470);	
			    	}
			    	else
				    	if(iAtributo == R.styleable.MinhaFoto_Altura) 
				    	{
					    	iAltura = typedArray.getInteger(iAtributo, 320);	
				    	}
		    }
	    } 

	    finally 
	    {
	    	typedArray.recycle();
	    }
	    
		ColocaImagem(strLocal, iLargura, iAltura); 
	}
	
	public MinhaFoto(Context context, AttributeSet attrs, int defStyle) 
	{
	    super(context, attrs, defStyle);
		ColocaImagem("rio", 470, 320);
	}
	
	private void ColocaImagem(String strLocal, int iAltura, int iLargura) 
	{
		ImageView imgImagem = (ImageView) this.findViewById(R.id.idImgImagem);
	    Bitmap btmRio = BitmapFactory.decodeResource(getResources(), R.drawable.rio);
	    Bitmap btmPoa = BitmapFactory.decodeResource(getResources(), R.drawable.poa);
		
	    if ( strLocal.equals("rio") )
	    {
		     btmRio = Bitmap.createScaledBitmap(btmRio, iAltura, iLargura, true);
		     imgImagem.setImageBitmap(btmRio);
	    }
	    else
	    {
		     btmPoa = Bitmap.createScaledBitmap(btmPoa, iAltura, iLargura, true);
		     imgImagem.setImageBitmap(btmPoa);
	    }   
	}
}


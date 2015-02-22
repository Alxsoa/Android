package com.example.listview_07;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContatosArrayAdapter extends ArrayAdapter<Contatos> 
{
	
	private LayoutInflater inflater;
	private List<Contatos> data;
	
	public ContatosArrayAdapter(Context context,List<Contatos> objects) 
	{
		super(context, R.layout.contatos_item_lista, objects);
		
		inflater= LayoutInflater.from(context);
		this.data=objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		ListaDados MinhaLista;
		if(convertView == null)
		{
			convertView = inflater.inflate(R.layout.contatos_item_lista, null);
			MinhaLista 	= new ListaDados();
			MinhaLista.imgImagem	=	(ImageView) convertView.findViewById(R.id.imageViewEmployer);
			MinhaLista.txtNome 		=	(TextView)  convertView.findViewById(R.id.textViewName);
			MinhaLista.txtEndereco 	=	(TextView)  convertView.findViewById(R.id.textViewAddress);
			convertView.setTag(MinhaLista);
		}
		else 
		{
			MinhaLista =(ListaDados) convertView.getTag();
		}
		
		if ( data.get(position).getName().toString().equals("Alexandre Soares"))
		{
			MinhaLista.imgImagem.setImageResource(R.drawable.alexandre);
		}
		else
		{
			if ( data.get(position).getName().toString().equals("Henrique Morbim"))
			{
				MinhaLista.imgImagem.setImageResource(R.drawable.henrique);
			}
			else
			{
				if ( data.get(position).getName().toString().equals("Luiz Gustavo"))
				{
					MinhaLista.imgImagem.setImageResource(R.drawable.gustavo);
				}
				else
				{
					if ( data.get(position).getName().toString().equals("Dimitri Tallemberg"))
					{
						MinhaLista.imgImagem.setImageResource(R.drawable.dimitri);
					}
				}
			}
		}
		
		
		
		
		
		MinhaLista.txtNome.setText((CharSequence) data.get(position).getName());	
		MinhaLista.txtEndereco.setText((CharSequence) data.get(position).getAddress());
		return convertView;
	}

	static class ListaDados
	{
		ImageView 	imgImagem;
		TextView 	txtNome;
		TextView 	txtEndereco;
	}
}

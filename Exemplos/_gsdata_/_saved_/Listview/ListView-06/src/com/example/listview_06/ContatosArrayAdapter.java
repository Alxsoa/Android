package com.example.listview_06;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
			MinhaLista = new ListaDados();
			MinhaLista.sNome =(TextView) convertView.findViewById(R.id.textViewName);
			MinhaLista.sEndereco =(TextView) convertView.findViewById(R.id.textViewAddress);
			convertView.setTag(MinhaLista);
		}
		else 
		{
			MinhaLista =(ListaDados) convertView.getTag();
		}		
		MinhaLista.sNome.setText((CharSequence) data.get(position).getName());
		MinhaLista.sEndereco.setText((CharSequence) data.get(position).getAddress());
		return convertView;
	}

	static class ListaDados
	{
		TextView sNome;
		TextView sEndereco;
	}
}

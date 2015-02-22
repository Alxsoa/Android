package com.example.listview_02;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends ListActivity 
{
	static final String[] strLinha = new String[] 	{	
													"Android", 
													"iOS",
													"Windows Mobile", 
													"Blackberry"
													};

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setListAdapter(new MobileArrayAdapter(this, strLinha));
	}

	@Override
	protected void onListItemClick(ListView lstView, View vwView, int iPosicao, long id) 
	{
		super.onListItemClick(lstView, vwView, iPosicao, id);
		
		Object objPosition = this.getListAdapter().getItem(iPosicao);
		String strLinha = objPosition.toString();
		Toast.makeText(this, "A Plataforma Selecionada Foi " + strLinha, Toast.LENGTH_SHORT).show();
	}
}
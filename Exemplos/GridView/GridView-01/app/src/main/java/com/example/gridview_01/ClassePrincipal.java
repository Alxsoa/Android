package com.example.gridview_01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class ClassePrincipal extends Activity 
{
	private int[] bandeiraPaises = 	{ 
										R.drawable.barbados, 
										R.drawable.brasil,
										R.drawable.canada, 
										R.drawable.chile, 
										R.drawable.costarica,
										R.drawable.elsalvador, 
										R.drawable.estadosunidos, 
										R.drawable.honduras 
									};
	GridView grdGrade;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		grdGrade = (GridView) findViewById(R.id.gridView);
		grdGrade.setAdapter(new ImageAdapter(this, bandeiraPaises,
									new GridView.LayoutParams(150, 150)));
	}
}



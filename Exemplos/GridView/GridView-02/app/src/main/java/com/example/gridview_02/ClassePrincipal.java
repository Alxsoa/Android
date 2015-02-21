package com.example.gridview_02;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ClassePrincipal extends Activity 
{
	private int[] iBandeiras = 	{ 
									R.drawable.barbados, 
									R.drawable.brasil,
									R.drawable.canada, 
									R.drawable.chile, 
									R.drawable.costarica,
									R.drawable.elsalvador, 
									R.drawable.estadosunidos, 
									R.drawable.honduras,
									R.drawable.pause
								};
	GridView grdGrade;
	MediaPlayer mdpHino;

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		grdGrade = (GridView) findViewById(R.id.gridView);
		grdGrade.setAdapter(new ImageAdapter(this, iBandeiras,
						new GridView.LayoutParams(150, 150)));
	
		mdpHino = MediaPlayer.create(this, R.raw.musica);
		try 
		{
			mdpHino.prepare();
		} 
		catch (Exception e) 
		{
		}
		
		grdGrade.setOnItemClickListener(new OnItemClickListener() 
		{
			public void onItemClick(AdapterView<?> parent, View v,int position, long id) 
			{
				switch (position) 
				{
					case 0:
							Toast.makeText(ClassePrincipal.this,"Bandeira de Barbados", Toast.LENGTH_SHORT).show();
							break;
						
					case 1:				
							Toast.makeText(ClassePrincipal.this,"Bandeira do Brasil", Toast.LENGTH_SHORT).show();
							mdpHino.start();						
							break;
						
					case 2:
							Toast.makeText(ClassePrincipal.this,"Bandeira do Canada", Toast.LENGTH_SHORT).show();
							break;
						
					case 3:
							Toast.makeText(ClassePrincipal.this,"Bandeira do Chile", Toast.LENGTH_SHORT).show();
							break;
						
					case 4:
							Toast.makeText(ClassePrincipal.this,"Bandeira da Costa Rica", Toast.LENGTH_SHORT).show();
							break;
						
					case 5:
							Toast.makeText(ClassePrincipal.this,"Bandeira de El Salvador", Toast.LENGTH_SHORT).show();
							break;
						
					case 6:
							Toast.makeText(ClassePrincipal.this,"Bandeira dos Estados Unidos", Toast.LENGTH_SHORT).show();
							break;
						
					case 7:
							Toast.makeText(ClassePrincipal.this,"Bandeira de Honduras", Toast.LENGTH_SHORT).show();
							break;
							
					case 8:
						mdpHino.pause();
						break;
				}
			}
		});	
	
	}
}

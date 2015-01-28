package com.example.listview_04;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity 
{
	MyCustomAdapter dataAdapter = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_main);
	 
	 displayListView();
	 checkButtonClick();
	}

	private void displayListView() 
	{
		 ArrayList<Country> countryList = new ArrayList<Country>();
		 Country country = new Country("AFG","Afghanistan",false);
		 countryList.add(country);
		 country = new Country("ALB","Albania",true);
		 countryList.add(country);
		 country = new Country("DZA","Algeria",false);
		 countryList.add(country);
		 country = new Country("ASM","American Samoa",true);
		 countryList.add(country);
		 country = new Country("AND","Andorra",true);
		 countryList.add(country);
		 country = new Country("AGO","Angola",false);
		 countryList.add(country);
		 country = new Country("AIA","Anguilla",false);
		 countryList.add(country);
		
		 dataAdapter = new MyCustomAdapter(this, R.layout.country_info, countryList);
		 ListView listView = (ListView) findViewById(R.id.listView1);
		 listView.setAdapter(dataAdapter);
		
		
		 listView.setOnItemClickListener(new OnItemClickListener() 
		 {
		  public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
		  {
		   Country country = (Country) parent.getItemAtPosition(position);
		   Toast.makeText ( getApplicationContext(),
				   			"Clicked on Row: " + country.getName(), 
				   			Toast.LENGTH_LONG).show();
		  }
		 });
	}

	private class MyCustomAdapter extends ArrayAdapter<Country> 
	{
		private ArrayList<Country> countryList;
	
		public MyCustomAdapter(Context context, int textViewResourceId, ArrayList<Country> countryList) 
		{
			super(context, textViewResourceId, countryList);
			this.countryList = new ArrayList<Country>();
			this.countryList.addAll(countryList);
		}
	
		private class ViewHolder 
		{
			 TextView code;
			 CheckBox name;
		}
	
		@Override
		public View getView(int position, View convertView, ViewGroup parent) 
		{
	
			ViewHolder holder = null;
			Log.v("ConvertView", String.valueOf(position));
	
			if (convertView == null) 
			{
				LayoutInflater vi = (LayoutInflater)getSystemService( Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.country_info, null);
	
				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.code);
				holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
				convertView.setTag(holder);
	
				holder.name.setOnClickListener( new View.OnClickListener() 
				{  
					public void onClick(View v) 
					{  
						CheckBox cb = (CheckBox) v ;  
						Country country = (Country) cb.getTag();  
						Toast.makeText (	getApplicationContext(),
											"Clicado " + cb.getText() +
											" e " + cb.isChecked(), 
											Toast.LENGTH_LONG).show();
											country.setSelected(cb.isChecked());
					}  
				});  
			} 
			else 
			{
				holder = (ViewHolder) convertView.getTag();
			}
	
			Country country = countryList.get(position);
			holder.code.setText(" (" +  country.getCode() + ")");
			holder.name.setText(country.getName());
			holder.name.setChecked(country.isSelected());
			holder.name.setTag(country);
	
			return convertView;
		}
	}

	private void checkButtonClick() 
	{
		Button myButton = (Button) findViewById(R.id.findSelected);
		myButton.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{

				StringBuffer responseText = new StringBuffer();
				responseText.append("Os Pa�ses Selecionados Foram \n");

				ArrayList<Country> countryList = dataAdapter.countryList;
				for(int i=0;i<countryList.size();i++)
				{
					Country country = countryList.get(i);
					if(country.isSelected())
					{
						responseText.append("\n" + country.getName());
					}
				}

				Toast.makeText(getApplicationContext(), responseText, Toast.LENGTH_LONG).show();
			}
		});
	}
}
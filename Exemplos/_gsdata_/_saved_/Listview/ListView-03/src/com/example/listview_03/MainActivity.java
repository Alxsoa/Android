package com.example.listview_03;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity 
{
	 ListView 	list;
	 Button 	btnAcao;
	 
	 String[] GENRES = new String[] {
			 							"Janeiro",	"Fevereiro",
			 							"Março", 	"Abril",
			 							"Maio", 	"Junho",
			 							"Julho", 	"Agosto",
			 							"Setembro", "Outubro",
			 							"Novembro", "Dezembro" 
			 						};
	    
	 ItemsAdapter adapter;
	 @Override
	 public void onCreate(Bundle savedInstanceState) 
	 {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_main);
	        
	     list = (ListView)findViewById(R.id.list);
	     btnAcao = (Button)findViewById(R.id.btnAcao);
	        
	     list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	     adapter = new ItemsAdapter(this,GENRES);
	     list.setAdapter(adapter);
	        
	     list.setOnItemClickListener(new OnItemClickListener() 
	     {
	    	 @Override
	    	 public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) 
	    	 {
	    		 CheckedTextView tv = (CheckedTextView)arg1;
	    		 toggle(tv);
	    	 }
	     });
	        
	     btnAcao.setOnClickListener(new OnClickListener() 
	     {
	    	 @Override
	    	 public void onClick(View v) 
	    	 {
	    		 String sAux;
	    		 if ( list.getCheckedItemCount() > 1 )
	    		 {
	    			 sAux = " Os Meses Selecionados Foram  \n"; 
	    		 }
	    		 else
	    		 {
	    			 sAux = " O Mes Selecionado Foi \n";
	    		 }

	    		 for(int i = 0;i<list.getChildCount();i++)
	    		 {
	    			 View view = list.getChildAt(i);
	    			 CheckedTextView cv =(CheckedTextView)view.findViewById(R.id.checkList);
	    			 if(cv.isChecked())
	    			 {
	    				 sAux = sAux + cv.getText().toString() + "\n ";
	    			 }
	    		 }
	    		 Toast.makeText(getBaseContext(),sAux, Toast.LENGTH_SHORT).show();
	    	 }
	     });

	 }
	    
	 private class ItemsAdapter extends BaseAdapter 
	 {
		 String[] items;

		 public ItemsAdapter(Context context, String[] item) 
		 {
			 this.items = item;
		 }

		 @Override
		 public View getView(int position, View convertView, ViewGroup parent) 
		 {
			 View v = convertView;
			 if (v == null) 
			 {
				 LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				 v = vi.inflate(R.layout.items, null);
			 } 
			 CheckedTextView post = (CheckedTextView) v.findViewById(R.id.checkList);
			 post.setText(items[position]);
			 return v;
		 }

		 public int getCount() 
		 {
			 return items.length;
		 }

		 public Object getItem(int position) 
		 {
			 return position;
		 }

		 public long getItemId(int position) 
		 {
			 return position;
		 }
	 }

	 public void toggle(CheckedTextView v)
	 {
		 if (v.isChecked())
	     {
			 v.setChecked(false);
	     }
	     else
	     {
	    	 v.setChecked(true);
         }
	 }
}

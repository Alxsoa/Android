package com.example.popupwindow_02;

//
// http://android-er.blogspot.com.br/2012/03/example-of-using-popupwindow.html
// http://stackoverflow.com/questions/15165454/should-i-use-a-popupwindow-or-dialogfragment-for-accepting-input
//

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity 
{
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Button btnOpenPopup = (Button)findViewById(R.id.openpopup);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener()
        {
		   @Override
		   public void onClick(View arg0) 
		   {
			   LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  	    
			   View popupView = layoutInflater.inflate(R.layout.popup, null);  
			   final PopupWindow popupWindow = new PopupWindow ( popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
		             
			   Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
			   btnDismiss.setOnClickListener(new Button.OnClickListener()
			   {
				   @Override
				   public void onClick(View v) 
				   {
					   popupWindow.dismiss();
				   }
				});
		               
			   	popupWindow.showAsDropDown(btnOpenPopup, 50, -30);	         
		   }
		});
    }
}
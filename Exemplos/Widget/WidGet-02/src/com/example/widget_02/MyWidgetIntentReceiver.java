package com.example.widget_02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


public class MyWidgetIntentReceiver extends BroadcastReceiver 
{

	private static int clickCount = 0;
	
	@Override
	public void onReceive(Context context, Intent intent) 
	{
		if(intent.getAction().equals("com.example.intent.action.CHANGE_PICTURE"))
		{
			updateWidgetPictureAndButtonListener(context);
		}
	}

	private void updateWidgetPictureAndButtonListener(Context context) 
	{
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
		remoteViews.setImageViewResource(R.id.widget_image, getImageToSet());
		remoteViews.setOnClickPendingIntent(R.id.widget_button, MyWidgetProvider.buildButtonPendingIntent(context));		
		MyWidgetProvider.pushWidgetUpdate(context.getApplicationContext(), remoteViews);
	}

	private int getImageToSet() 
	{
		clickCount++;
		return clickCount % 2 == 0 ? R.drawable.rio : R.drawable.portoalegre;
	}
}

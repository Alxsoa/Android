package mine.testproject.com;

//
// http://mrbool.com/how-to-work-with-threads-and-timers-in-android-applications/28676#
//

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestThread2Activity extends Activity 
{
	private Button startMainThread;
	private Button startChildThread;	
	private Handler mainThreadHandler;
	private Button sendMsgToMain;
    private Handler childThreadHandler;
	private Button sendMsgToChild;
	private MainThread mainThread;
	private ChildThread childThread;
	private Button postToMain;
	private Button asyncTask;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sendMsgToMain = (Button) findViewById(R.id.sendMsgToMain);
        sendMsgToChild = (Button) findViewById(R.id.sendMsgToChild);
        postToMain = (Button) findViewById(R.id.postToMain);
        asyncTask = (Button) findViewById(R.id.asyncTask);
       
        mainThread = new MainThread();
        childThread = new ChildThread();
        
        startMainThread = (Button)findViewById(R.id.startMain);
        startMainThread.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				mainThread.start();
				mainThread.run();				
			}
		});        
        
        startChildThread = (Button)findViewById(R.id.startChild);
        startChildThread.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				childThread.start();
				childThread.run();				
			}
		});     
        
        asyncTask.setOnClickListener(new View.OnClickListener()
        {
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				AsyncTask<Integer, Object, Integer> newAsyncTask = new AsyncTask<Integer, Object, Integer>()
				{
					
					@Override
					protected void onPreExecute() 
					{
						// TODO Auto-generated method stub
						super.onPreExecute();
	    				Toast msg2 = Toast.makeText(TestThread2Activity.this, "Async Task Started", Toast.LENGTH_SHORT);
	    				msg2.show();
					}

					@Override
					protected Integer doInBackground(Integer... params) 
					{
						// TODO Auto-generated method stub
						// Toast msgs not working here!!
	    				//Toast msg2 = Toast.makeText(TestThread2Activity.this, "Background Async Task Started, passed parameter ", Toast.LENGTH_SHORT);
	    				//msg2.show();
						int x = 10;
						
	    				
						return x*100;
					}
					
					@Override
					protected void onProgressUpdate(Object... values) 
					{
						// TODO Auto-generated method stub
						super.onProgressUpdate(values);
						// Toast msg not shown!!
	    				Toast msg2 = Toast.makeText(TestThread2Activity.this, "Executing...", Toast.LENGTH_SHORT);
	    				msg2.show();
					}
					@Override
					protected void onPostExecute(Integer result) 
					{
						// TODO Auto-generated method stub
						super.onPostExecute(result);
	    				Toast msg2 = Toast.makeText(TestThread2Activity.this, "Async Task Executed and returned" + result, Toast.LENGTH_SHORT);
	    				msg2.show();
					}
				};
				
				newAsyncTask.execute(new Integer[] {100});
				
			}
		});
    }
    
    // Inner Main Thread Class
    public class MainThread extends Thread
    {
    	public MainThread()
    	{
        	mainThreadHandler = new Handler()
            {
            	@Override
            	public void handleMessage(Message msg) 
            	{
            		// TODO Auto-generated method stub
            		super.handleMessage(msg);
    				Toast msg2 = Toast.makeText((Context)msg.obj, "Child Thread sent message with arg1 " + msg.arg1, Toast.LENGTH_SHORT);
    				msg2.show();
            	}
            };
    	}
    	@Override
    	public synchronized void start()
    	{
			Toast msg = Toast.makeText(TestThread2Activity.this, "Main Thread Started", Toast.LENGTH_SHORT);
			msg.show();	
    	};
    	@Override
    	public void run() 
    	{

    		sendMsgToChild.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) 
    			{
    				// TODO Auto-generated method stub
    				Message msg = new Message();
    				msg.arg1 = 20;
    				msg.obj = v.getContext();
    				childThreadHandler.sendMessage(msg);
    			
    			}
    		});
    	};
    }
    
    // Inner Child Thread Class
    public class ChildThread extends Thread
    {
    	@Override
    	public synchronized void start()
    	{
			Toast msg = Toast.makeText(TestThread2Activity.this, "Child Thread Started", Toast.LENGTH_SHORT);
			msg.show();	
    	};
    	public ChildThread()
    	{
    		childThreadHandler = new Handler()
            {
            	@Override
            	public void handleMessage(Message msg) 
            	{
            		// TODO Auto-generated method stub
            		super.handleMessage(msg);
    				Toast msg2 = Toast.makeText((Context)msg.obj, "Main Thread sent message with arg1 " + msg.arg1, Toast.LENGTH_SHORT);
    				msg2.show();
            	}
            };
    	}
    	
    	private Runnable myRunnable = new Runnable()
    	{
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				
				Toast msg = Toast.makeText(TestThread2Activity.this, "I run on Main Thread", Toast.LENGTH_SHORT);
				msg.show();	
				
			}
		};
    	@Override
    	public void run() 
    	{

    		sendMsgToMain.setOnClickListener(new View.OnClickListener() {
    			
    			@Override
    			public void onClick(View v) 
    			{
    				// TODO Auto-generated method stub
    				Message msg = new Message();
    				msg.arg1 = 10;
    				msg.obj = v.getContext();
    				mainThreadHandler.sendMessage(msg);
    			
    			}
    		});
    		
            postToMain.setOnClickListener(new View.OnClickListener()
            {
    			
    			@Override
    			public void onClick(View v)
    			{
    				mainThreadHandler.post(myRunnable);
    				
    			}
    		});
    	};
    	

    	
    }
}
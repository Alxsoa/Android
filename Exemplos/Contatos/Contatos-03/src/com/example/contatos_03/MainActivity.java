package com.example.contatos_03;

import java.util.ArrayList;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		String TAG = "Contatos";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ContentResolver cr = getContentResolver();
    	String where = ContactsContract.Data.DISPLAY_NAME + " = ? ";
    	String[] params = new String[] {"Alan Turing"};
    
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        ops.add(ContentProviderOperation.newDelete(ContactsContract.RawContacts.CONTENT_URI)
    	        .withSelection(where, params)
    	        .build());
        try 
        {
			cr.applyBatch(ContactsContract.AUTHORITY, ops);
		} 
        catch (RemoteException e) 
        {
			e.printStackTrace();
		} 
        catch (OperationApplicationException e) 
        {
			e.printStackTrace();
		}
		Log.e( TAG, "Contato Removido com Sucesso"); 
	}
}

package com.example.contatos_04;

// ===================================================================    
// Modifica um Contato Especifico
// =================================================================== 

import java.util.ArrayList;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.util.Log;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		String TAG = "Contatos";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ContentResolver cr = getContentResolver();
    	
        String where = ContactsContract.Data.DISPLAY_NAME + " = ? AND " + 
        			ContactsContract.Data.MIMETYPE + " = ? AND " +
        			String.valueOf(ContactsContract.CommonDataKinds.Phone.TYPE) + " = ? ";
        String[] params = new String[] {"Alan Turing",
        		ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE,
        		String.valueOf(ContactsContract.CommonDataKinds.Phone.TYPE_HOME)};

        Cursor phoneCur = managedQuery(ContactsContract.Data.CONTENT_URI, null, where, params, null);
        
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        
        if ( (null == phoneCur)  ) 
        {
        	// Cria o contato caso n‹o exista
        } 
        else 
        {
        	ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
        	        .withSelection(where, params)
        	        .withValue(ContactsContract.CommonDataKinds.Phone.DATA, "123456")
        	        .build());
        }
        
        phoneCur.close();
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

		Log.e( TAG, "Contato Modificado com Sucesso"); 
	}
}

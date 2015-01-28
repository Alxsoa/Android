package com.example.contatos_02;

// ===================================================================    
// Cria um Novo Contato
// =================================================================== 

import java.util.ArrayList;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.util.Log;

public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		String TAG = "MeuLog";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		String name = "Alan Turing";
		String phone = "24631926";
		ContentResolver cr = getContentResolver();
    	Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,null, null, null, null);
        
    	if (cur.getCount() > 0) 
    	{
        	while (cur.moveToNext()) 
        	{
        		String existName = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        		if (existName.contains(name)) 
        		{
          		  	Log.e( TAG, "Este Contato ja Existe");  
                	return;        			
        		}
        	}
    	}
    	
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, "accountname@gmail.com")
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, "com.google")
                .build());
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                .withValue(ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, name)
                .build());
        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
                .withValue(ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, phone)
                .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_HOME)
                .build());
        
        try 
        {
			cr.applyBatch(ContactsContract.AUTHORITY, ops);
			Log.e( TAG, "Contato Criado com Sucesso");  
		} 
        catch (RemoteException e) 
        {
			e.printStackTrace();
		} 
        catch (OperationApplicationException e) 
        {
			e.printStackTrace();
		}
		
	}
}

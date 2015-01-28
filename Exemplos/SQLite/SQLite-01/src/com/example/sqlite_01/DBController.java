package com.example.sqlite_01;


import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBController  extends SQLiteOpenHelper 
{
	String TAG = "SQLite";
	private static final String DATABASE_NAME = "banco";
	private static final String TABLE_NAME = "produtos";
    private static final String KEY_ID = "id";
    private static final String KEY_PRODUTO_NOME = "nome";
    private static final String KEY_PRODUTO_CODE = "codigo";
	private static final int DATABASE_VERSION = 1;

	public DBController (Context Context) 
	{
        super(Context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.e( TAG, "Entrei no Controller");  
    }
	
	@Override
	public void onCreate(SQLiteDatabase db) 
	{
        String strQuery = 	"CREATE TABLE " 
        					+ TABLE_NAME + "( "
        					+ KEY_ID 
        					+ " INTEGER PRIMARY KEY, " 
        					+ KEY_PRODUTO_NOME + " TEXT, "
        					+ KEY_PRODUTO_CODE + " TEXT" 
        					+ ")";
        db.execSQL(strQuery);
		Log.e( TAG, "Banco de Dados Criado");  
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int version_old, int current_version) 
	{
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
		Log.e( TAG, "Banco de Dados Atualizado");  
	}
	
    void addProduto (String strProdutoNome, String strProdutoCode) 
    {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUTO_NOME, strProdutoNome );
        values.put(KEY_PRODUTO_CODE, strProdutoCode); 
 
        db.insert(TABLE_NAME, null, values);
        db.close(); 
    }
}

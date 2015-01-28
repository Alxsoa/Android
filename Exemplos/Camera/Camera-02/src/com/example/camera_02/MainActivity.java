package com.example.camera_02;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private static final int MeuRequest = 1001;
	public static final int MEDIA_TYPE_IMAGE = 1;
	private static final String DIRETORIO = "Minhas Imagens";
	private static String TAG = "MeuLog";
	private Uri uriArquivo; 
	private ImageView imgPrevia;
	private Button btnFoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imgPrevia = (ImageView) findViewById(R.id.idImgPreview);
		btnFoto = (Button) findViewById(R.id.idBtnFoto);

		btnFoto.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View v) 
			{
				captureImage();
			}
		});

		if (!TemCamera()) 
		{
			Toast.makeText(getApplicationContext(),"Aparelho Nao Suporta Camera",Toast.LENGTH_LONG).show();
			finish();
		}
	}

	private boolean TemCamera () 
	{
		if (getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) 
			return true;
		else 
			return false;
	}

	private void captureImage() 
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		uriArquivo = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

		intent.putExtra(MediaStore.EXTRA_OUTPUT, uriArquivo);
		startActivityForResult(intent, MeuRequest);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) 
	{
		super.onSaveInstanceState(outState);
		outState.putParcelable("MeuParcelable", uriArquivo);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) 
	{
		super.onRestoreInstanceState(savedInstanceState);
		uriArquivo = savedInstanceState.getParcelable("MeuParcelable");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		if (requestCode == MeuRequest) 
		{
			if (resultCode == RESULT_OK) 
			{
				previewCapturedImage();
			} 
			else 
			{
				if (resultCode == RESULT_CANCELED) 
				{
					Toast.makeText(getApplicationContext(),"Usuario Cancelou a Captura", Toast.LENGTH_SHORT).show();
				} 
				else 
				{
					Toast.makeText(getApplicationContext(),"Falha na Captura", Toast.LENGTH_SHORT).show();
				}
			}
		}
	 }

	private void previewCapturedImage() 
	{
		try 
		{
			imgPrevia.setVisibility(View.VISIBLE);
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 8;
			
			final Bitmap bitmap = BitmapFactory.decodeFile(uriArquivo.getPath(),options);
			imgPrevia.setImageBitmap(bitmap);
		} 
		catch (NullPointerException e) 
		{
			e.printStackTrace();
		}
	}

	public Uri getOutputMediaFileUri(int type) 
	{
		return Uri.fromFile(getOutputMediaFile(type));
	}

	private static File getOutputMediaFile(int type) 
	{

		File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),DIRETORIO);

		if (!mediaStorageDir.exists()) 
		{
			if (!mediaStorageDir.mkdirs()) 
			{
				Log.v(TAG, "Falha na Criacao "+ DIRETORIO + " directory");
				return null;
			}
		}

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",Locale.getDefault()).format(new Date());
		File mediaFile;
		
		if (type == MEDIA_TYPE_IMAGE) 
		{
			mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
		} 
		else 
		{
			return null;
		}

		return mediaFile;
	}
}

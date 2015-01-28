package br.exemplopopupwindow;


import br.exemplopopupwindow.util.Popup;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	public void showPopupWindow(View view)
	{
		
		switch ( view.getId() )
		{
			case R.id.ivInfoNickname : 	Popup.showPopupWindow(view, "Nickname", "Esse ser� o nome apresentado aos usu�rios de nossa rede.", "Ok");
										break;
										
			case R.id.ivInfoEmail	 :	Popup.showPopupWindow(view, "Email", "Esse ser� o seu login de acesso a rede e tb o endere�o que receber� as mensagens", "Ok");
										break;
										
			case R.id.ivInfoPassword :  Popup.showPopupWindow(view, "Senha", "Sua senha deve estar entre 8 e 20 caracteres e deve conter letras e n�meros", "Ok");
										break;
			
		}
	}
}

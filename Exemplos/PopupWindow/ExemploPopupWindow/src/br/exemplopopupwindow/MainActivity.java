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
			case R.id.ivInfoNickname : 	Popup.showPopupWindow(view, "Nickname", "Esse será o nome apresentado aos usuários de nossa rede.", "Ok");
										break;
										
			case R.id.ivInfoEmail	 :	Popup.showPopupWindow(view, "Email", "Esse será o seu login de acesso a rede e tb o endereço que receberá as mensagens", "Ok");
										break;
										
			case R.id.ivInfoPassword :  Popup.showPopupWindow(view, "Senha", "Sua senha deve estar entre 8 e 20 caracteres e deve conter letras e números", "Ok");
										break;
			
		}
	}
}

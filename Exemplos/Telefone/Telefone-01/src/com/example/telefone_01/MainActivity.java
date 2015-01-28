package com.example.telefone_01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends Activity 
{
	TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);      
        textView1=(TextView)findViewById(R.id.textView1);
        
        TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String IMEINumber=tm.getDeviceId();
        String subscriberID=tm.getDeviceId();
        String SIMSerialNumber=tm.getSimSerialNumber();
        String networkCountryISO=tm.getNetworkCountryIso();
        String SIMCountryISO=tm.getSimCountryIso();
        String softwareVersion=tm.getDeviceSoftwareVersion();
        String voiceMailNumber=tm.getVoiceMailNumber();
        

        String strphoneType="";    
        int phoneType=tm.getPhoneType();

        switch (phoneType) 
        {
            case 	(TelephonyManager.PHONE_TYPE_CDMA):
                   	strphoneType="CDMA";
                   	break;
                   	
            case 	(TelephonyManager.PHONE_TYPE_GSM): 
                   	strphoneType="GSM";              
                   	break;
                   	
            case 	(TelephonyManager.PHONE_TYPE_NONE):
	    			strphoneType="NONE";              
	                break;
         }
        
        boolean isRoaming=tm.isNetworkRoaming();
        
        String strInfo="Detalhes do Telefone: \n";
        strInfo+="\n Numero IMEI: "+IMEINumber;
        strInfo+="\n ID do Assinante: "+subscriberID;
        strInfo+="\n Numero Serial do SIM: "+SIMSerialNumber;
        strInfo+="\n Rede do Pais: "+networkCountryISO;
        strInfo+="\n Pais do SIM: "+SIMCountryISO;
        strInfo+="\n Versao de Software: "+softwareVersion;
        strInfo+="\n Numero do Correio de Voz: "+voiceMailNumber;
        strInfo+="\n Tipo da Rede: "+strphoneType;
        strInfo+="\n Esta em Roaming: "+isRoaming;
        
        textView1.setText(strInfo);
    }
}

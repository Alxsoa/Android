package com.example.listview_07;

public class Contatos 
{

	private String sNome;
	private String sEndereco;
	
	public Contatos()
	{
		
	}
	
	public Contatos(String sNome, String sEndereco ) 
	{
		this.sNome=sNome;
		this.sEndereco=sEndereco;
	}
	
	public String getName() 
	{
		return sNome;
	}
	public void setName(String sNome) 
	{
		this.sNome = sNome;
	}
	public String getAddress() 
	{
		return sEndereco;
	}
	public void setAddress(String sEndereco) 
	{
		this.sEndereco = sEndereco;
	}

}

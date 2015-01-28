package com.example.sqlite_01;

public class Produto 
{
	
// ====================================================================
// Definicao dos Componenetes da Classe
// ====================================================================
	
	int _iProdutoID;
	String _strProdutoName;
	String _strProdutoCode;
	
// ====================================================================
// Definicao do Construtor Vazio
// ====================================================================
	public Produto()
	{
		
	}

// ====================================================================
// Definicao do Construtor 
// ====================================================================
	
	public Produto (int iProdutoID, String strProdutoName, String strProdutoCode)
	{
	
		this._iProdutoID = iProdutoID;
		this._strProdutoName = strProdutoName;
		this._strProdutoCode = strProdutoCode;
		
	}
	
// ====================================================================
// Definicao do Construtor 
// ====================================================================
	
	public Produto (String strProdutoName, String strProdutoCode)
	{
		this._strProdutoName = strProdutoName;
		this._strProdutoCode = strProdutoCode;
	}
	
// ====================================================================
// Recuperando a Identificacao
// ====================================================================
	
	public int getProdutoID ()
	{
		return this._iProdutoID;
	}
	
// ====================================================================
// Definindo a Identificacao
// ====================================================================
	
	public void SetProdutoID (int _iProdutoID)
	{
		this._iProdutoID = _iProdutoID;
	}
	
// ====================================================================
// Recuperando o Nome do Produto
// ====================================================================
	
	public String getProdutoName ()
	{
		return this._strProdutoName;
	}
	
// ====================================================================
// Definindo o Nome do Produto
// ====================================================================
	
	public void setProdutoName (String strProdutoName)
	{
		this._strProdutoName = strProdutoName;
	}
	
// ====================================================================
// Recuperando o Codigo do Produto
// ====================================================================
	
	public String getProdutoCode ()
	{
		return this._strProdutoCode;
	}
	
// ====================================================================
// Definindo o Nome do Produto
// ====================================================================
	
	public void setProdutoCode (String strProdutoCode)
	{
		this._strProdutoCode = strProdutoCode;
	}
}

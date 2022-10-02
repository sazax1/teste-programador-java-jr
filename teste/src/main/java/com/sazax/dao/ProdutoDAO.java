package com.sazax.dao;

import java.util.List;

import com.sazax.entidade.Produto;

public interface ProdutoDAO {
	
	//CRUD
	public Produto addProduto(Produto produto) throws DaoException;

	// QUERIES
	public List<Produto> findAll() throws DaoException;

}



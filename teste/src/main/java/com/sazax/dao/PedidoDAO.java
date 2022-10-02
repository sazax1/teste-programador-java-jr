package com.sazax.dao;

import java.util.List;

import com.sazax.entidade.Pedido;
import com.sazax.entidade.Produto;

public interface PedidoDAO  {
	
	public Pedido addPedido(Pedido pedido) throws DaoException;
	
	public List<Produto> findAll() throws DaoException;
}

package com.sazax.dao;

import com.sazax.entidade.Cliente;

public interface ClienteDAO {

	// CRUD
	public Cliente addCliente(Cliente cliente) throws DaoException;

}

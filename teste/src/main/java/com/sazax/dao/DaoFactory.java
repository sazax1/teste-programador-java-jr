package com.sazax.dao;

public final class DaoFactory {
	
	private static final String IMPL_TYPE = "jdbc";
	
	private DaoFactory() {
		
	}
	
	public static ProdutoDAO getProdutoDAO() throws DaoException{
		switch (IMPL_TYPE) {
		case "jdbc":
			return new JdbcProdutoDAO();
		default:
			throw new DaoException("Conexao Invalida");
		}
	}
	
	public static ClienteDAO getClienteDAO() throws DaoException{
		switch (IMPL_TYPE) {
		case "jdbc":
			return new JdbcClienteDAO();
		default:
			throw new DaoException("Conexao Invalida");
		}
	}
	
	public static PedidoDAO getPedidoDAO() throws DaoException{
		switch (IMPL_TYPE) {
		case "jdbc":
			return new JdbcPedidoDAO();
		default:
			throw new DaoException("Conexao Invalida");
		}
	}

}

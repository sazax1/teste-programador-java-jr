package com.sazax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sazax.conexao.DbConexao;
import com.sazax.entidade.Pedido;
import com.sazax.entidade.Produto;

public class JdbcPedidoDAO implements PedidoDAO {
	
	@Override
	public Pedido addPedido(Pedido pedido) throws DaoException {

	String sql = "insert into pedido(descricao) values (?)";
	
	try(
			Connection conn = DbConexao.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		){
		stmt.setString(1, pedido.getDescricao());
		
		stmt.executeUpdate();
		ResultSet keys = stmt.getGeneratedKeys();
		keys.next();
		keys.getInt(1);
		pedido.setId(keys.getInt(1));
		
		pedido.setData(sql);
		
		pedido.setTotal(Produto.unidade * Produto.valor);
		
		return pedido;
	}
	catch(Exception ex) {
		throw new DaoException(ex);
	}
}

private Produto toProduto(ResultSet rs) throws SQLException{
	Produto p = new Produto();
	p.setDescricao(rs.getString("Descricao"));
	p.setUnidade(rs.getInt("Unidade"));
	p.setValor(rs.getFloat("Valor"));
	return p;
	
}

@Override
public List<Produto> findAll() throws DaoException {
	String sql = "select * from  produto";
	List<Produto> list = new ArrayList<>();
	
	try(

			Connection conn = DbConexao.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
	){
		while(rs.next()) {
			Produto p = toProduto(rs);
			list.add(p);
		}
	}
	catch(Exception ex) {
		throw new DaoException(ex);
	}
	return list;
}
}

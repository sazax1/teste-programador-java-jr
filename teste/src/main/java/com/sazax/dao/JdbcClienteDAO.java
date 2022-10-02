package com.sazax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.sazax.conexao.DbConexao;
import com.sazax.entidade.Cliente;

public class JdbcClienteDAO implements ClienteDAO {

	public Cliente addCliente(Cliente cliente) throws DaoException {
		String sql = "insert into cliente(nome, cpf, email, phone) values (?, ?, ?, ?)";
		
		try(
				Connection conn = DbConexao.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			){
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getPhone());
			
			stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();
			keys.next();
			keys.getInt(1);
			cliente.setId(keys.getInt(1));
			
			return cliente;
		}
		catch(Exception ex) {
			throw new DaoException(ex);
		}
		
	}


}

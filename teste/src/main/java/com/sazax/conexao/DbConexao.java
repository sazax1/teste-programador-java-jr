package com.sazax.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbConexao {
	private static String driver, url, user, password;

	private DbConexao() {
	}

	static {
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		driver = rb.getString("jdbc.driver");
		url = rb.getString("jdbc.url");
		user = rb.getString("jdbc.user");
		password = rb.getString("jdbc.password");
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);
	}
}

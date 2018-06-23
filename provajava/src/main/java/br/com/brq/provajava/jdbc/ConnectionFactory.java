package br.com.brq.provajava.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection connection;

	public Connection getConnection() {

		try {
			if (connection == null) {
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost/ccee?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false",
						"candidato", "123456");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return connection;
	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

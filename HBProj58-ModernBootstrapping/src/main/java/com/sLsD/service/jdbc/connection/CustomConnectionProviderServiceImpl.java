package com.sLsD.service.jdbc.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.zaxxer.hikari.HikariDataSource;

public class CustomConnectionProviderServiceImpl implements ConnectionProvider {

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("My Custom getConnection(-) method");
		//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sumitodbd","sum89it");
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("sumitodbd");
		ds.setPassword("sum89it");
		ds.setMinimumIdle(10);
		ds.setMaximumPoolSize(20);
		return ds.getConnection();
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		System.out.println("My Custom closeConnection(-) method");
		conn.close();

	}

	@Override
	public boolean supportsAggressiveRelease() {
		return false;
	}

}

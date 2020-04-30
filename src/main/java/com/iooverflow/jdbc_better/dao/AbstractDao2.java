package com.iooverflow.jdbc_better.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao2 {

	private final String url;
	private final String username;
	private final String password;

	public AbstractDao2(final String url, final String username, final String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	protected final Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

}
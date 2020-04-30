package com.iooverflow.jdbc_better.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class AbstractDao3 {

	private final DataSource dataSource;

	public AbstractDao3(final DataSource dataSource) {
		this.dataSource = dataSource;
	}

	protected final Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
package com.iooverflow.jdbc_better.dao;

import com.iooverflow.jdbc_better.jdbc.JdbcManager;

public abstract class AbstractDao {
	
	private JdbcManager jdbcManager;

	public AbstractDao(final JdbcManager jdbcManager) {
		this.jdbcManager = jdbcManager;
	}

	protected final JdbcManager jdbcManager() {
		return jdbcManager;
	}
}
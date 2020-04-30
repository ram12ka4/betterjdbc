package com.iooverflow.jdbc_better.jdbc;

import java.util.List;

import com.iooverflow.jdbc_better.exception.DataAccessException;

public interface JdbcManager {
	
	<T> List<T> select(String sql, RowMapper<T> rowMapper, Object... parameters) throws DataAccessException;

	long insertAndGetId(final String sql, final Object... parameters) throws DataAccessException;

	int update(final String sql, final Object... parameters) throws DataAccessException;
}
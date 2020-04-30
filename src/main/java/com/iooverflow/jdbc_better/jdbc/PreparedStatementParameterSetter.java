package com.iooverflow.jdbc_better.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementParameterSetter {
	void setParameters(final PreparedStatement statement, final Object... parameters) throws SQLException;
}
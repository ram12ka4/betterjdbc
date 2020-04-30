package com.iooverflow.jdbc_better.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

//but I can define an interface which maps data in a ResultSet row to a Java object and let the user
//pass an instance of class implementing the interface or an anonymous class instance of the interface can
//be used too. What I need to consider is the return type and the ResultSet as I’m now trying to map the data in 
//		the ResultSet to a Java object (return type). So the mapper interface should look like.

public interface RowMapper<T> {
	T map(ResultSet resultSet) throws SQLException;
}


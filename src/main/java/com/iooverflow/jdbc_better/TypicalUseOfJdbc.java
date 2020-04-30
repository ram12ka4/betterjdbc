package com.iooverflow.jdbc_better;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iooverflow.jdbc_better.beans.Address;
import com.iooverflow.jdbc_better.beans.Person;

public final class TypicalUseOfJdbc {

	
	public static void main(final String[] args) {
		Connection connection = null;

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betterjdbc", "root", "R@mpa5sword");

			final String sql = "SELECT * FROM people";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery("SELECT * FROM people");
			final List<Person> people = new ArrayList<Person>();
			while (resultSet.next()) {
				final Person person = new Person();
				person.setId(resultSet.getLong("person_id"));
				person.setSurname(resultSet.getString("surname"));
				person.setGivenName(resultSet.getString("given_name"));
				final Address address = new Address(resultSet.getString("street"), resultSet.getString("city"),
						resultSet.getString("state"), resultSet.getString("country"), resultSet.getString("postcode"));
				person.setAddress(address);
				people.add(person);
			}
			System.out.println(people);
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != resultSet) {
				try {
					resultSet.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != statement) {
				try {
					statement.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != connection) {
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

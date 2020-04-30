package com.iooverflow.jdbc_better;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iooverflow.jdbc_better.beans.Address;
import com.iooverflow.jdbc_better.beans.Book;
import com.iooverflow.jdbc_better.beans.Person;

public final class TypicalUseOfJdbc2 {

	public static void main(final String[] args) {
		testInsert();
		testSelect();
	}

	private static void testInsert() {
		Connection connection = null;

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betterjdbc", "root", "R@mpa5sword");

			final String sql = "SELECT * FROM people";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			final ResultSet resultSet2 = connection.prepareStatement("SELECT * FROM books").executeQuery();

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

			final List<Book> books = new ArrayList<Book>();
			while (resultSet2.next()) {
				final Book book = new Book();
				book.setTitle(resultSet2.getString("title"));
				book.setAuthours(resultSet2.getString("authours"));
				books.add(book);
			}
			System.out.println(books);
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			closeQuietly(connection, statement, resultSet);
		}

	}

	private static void testSelect() {
		Connection connection = null;

		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betterjdbc", "root", "R@mpa5sword");
			final String sql = "SELECT * FROM people";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
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
			closeQuietly(connection, statement, resultSet);
		}
	}

	private static void closeQuietly(final Connection connection, final PreparedStatement statement,
			final ResultSet resultSet) {
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

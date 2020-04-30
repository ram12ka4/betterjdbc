package com.iooverflow.jdbc_better.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iooverflow.jdbc_better.beans.Book;
import com.iooverflow.jdbc_better.dao.AbstractDao2;
import com.iooverflow.jdbc_better.dao.BookDao;

public class BookDaoImpl2 extends AbstractDao2 implements BookDao {
	
	public BookDaoImpl2(final String url, final String username, final String password) {
		super(url, username, password);
	}

	@Override
	public Book find(final Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		final List<Book> result = new ArrayList<Book>();
		
		//final List<T> result = new ArrayList<T>();
		
		try {
			connection = getConnection();
			final String sql = "SELECT * FROM book WHERE book_id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				final Book book = new Book();
				book.setId(resultSet.getLong("book_id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthours(resultSet.getString("authours"));
				book.setEdition(resultSet.getString("edition"));
				book.setIsbn10(resultSet.getString("isbn10"));
				book.setIsbn13(resultSet.getString("isbn13"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setPublishingDate(resultSet.getDate("publishing_date"));
				result.add(book);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != resultSet)
				try {
					resultSet.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}

			if (null != statement)
				try {
					statement.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}

			if (null != connection)
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
		}
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<Book> findBooksByPublisher(final String publisher) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		final List<Book> result = new ArrayList<Book>();
		try {
			connection = getConnection();
			final String sql = "SELECT * FROM book WHERE publisher = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, publisher);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				final Book book = new Book();
				book.setId(resultSet.getLong("book_id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthours(resultSet.getString("authours"));
				book.setEdition(resultSet.getString("edition"));
				book.setIsbn10(resultSet.getString("isbn10"));
				book.setIsbn13(resultSet.getString("isbn13"));
				book.setPublisher(resultSet.getString("publisher"));
				book.setPublishingDate(resultSet.getDate("publishing_date"));
				result.add(book);
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != resultSet)
				try {
					resultSet.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}

			if (null != statement)
				try {
					statement.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}

			if (null != connection)
				try {
					connection.close();
				} catch (final SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}
}

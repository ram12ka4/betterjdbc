package com.iooverflow.jdbc_better.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iooverflow.jdbc_better.beans.Book;
import com.iooverflow.jdbc_better.dao.AbstractDao;
import com.iooverflow.jdbc_better.dao.BookDao;
import com.iooverflow.jdbc_better.jdbc.JdbcManager;
import com.iooverflow.jdbc_better.jdbc.RowMapper;

public class BookDaoImpl extends AbstractDao implements BookDao {

	private static final RowMapper<Book> BOOK_MAPPER = new RowMapper<Book>() {

		@Override
		public Book map(final ResultSet resultSet) throws SQLException {
			final Book book = new Book();
			book.setId(resultSet.getLong("book_id"));
			book.setTitle(resultSet.getString("title"));
			book.setAuthours(resultSet.getString("authours"));
			book.setEdition(resultSet.getString("edition"));
			book.setIsbn10(resultSet.getString("isbn10"));
			book.setIsbn13(resultSet.getString("isbn13"));
			book.setPublisher(resultSet.getString("publisher"));
			book.setPublishingDate(resultSet.getDate("publishing_date"));
			return book;
		}
	};

	public BookDaoImpl(final JdbcManager jdbcManager) {
		super(jdbcManager);
	}

	@Override
	public Book find(final Long id) {
		final List<Book> result = jdbcManager().select("SELECT * FROM book WHERE book_id = ?", BOOK_MAPPER, id);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<Book> findBooksByPublisher(final String publisher) {
		return jdbcManager().select("SELECT * FROM book WHERE publisher = ?", BOOK_MAPPER, publisher);
	}
}

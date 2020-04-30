package com.iooverflow.jdbc_better.dao;

import java.util.List;

import com.iooverflow.jdbc_better.beans.Book;

public interface BookDao {
	
	Book find(Long id);

	List<Book> findBooksByPublisher(String publisher);
}
package com.library.dao;

import com.library.entities.Book;

import java.util.List;

public interface BookDao {

	Book getBookbyId(long id);
	
	List<Book> getAllBooks();
	
	void addBook(Book book);
	
	void updateBook(Book book);
	
	void removeBook(Book book);
	
	List<Book> getAllBooksWithoutId();
	
	List<Book> getAllBooksForBookReaderByName(String name);
}

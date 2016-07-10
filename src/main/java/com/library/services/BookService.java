package com.library.services;

import com.library.entities.Book;

import java.util.List;

public interface BookService {

	Book getBookbyId(long id);
	
	List<Book> getAllBooks();
	
	void addBook(Book book);
	
	void updateBook(Book book);
	
	void removeBook(Book book);
	
	List<Book> getAllBooksWithoutId();
	
	List<Book> getAllBooksForBookReaderByName(String name);
	
}

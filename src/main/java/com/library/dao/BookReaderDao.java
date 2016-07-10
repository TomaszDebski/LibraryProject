package com.library.dao;

import com.library.entities.BookReader;

import java.util.List;


public interface BookReaderDao {

	BookReader getBookReaderbyId(long id);
	
	List<BookReader> getAllBookReader();
	
	void addBookReader(BookReader bookReader);
	
	void updateBookReader(BookReader bookReader);
	
	void removeBookReader(BookReader bookReader);
	
	Long bookReaderCount();
	
	List<BookReader> getAllBookReaderGraph();
	
	BookReader getBookReaderByUsername(String username);
}

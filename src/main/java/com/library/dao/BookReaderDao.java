package com.library.dao;

import com.library.entities.BookReader;

import java.util.List;

/**
 * @author Tomasz Dębski
 *
 */
public interface BookReaderDao {

	BookReader getBookReaderbyId(long id);
	
	List<BookReader> getAllBookReader();
	
	void addBookReader(BookReader bookReader);
	
	void updateBookReader(BookReader bookReader);
	
	void removeBookReader(BookReader bookReader);
	
	BookReader getBookReaderByUsername(String username);
}

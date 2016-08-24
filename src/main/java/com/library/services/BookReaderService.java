package com.library.services;

import com.library.entities.BookReader;

import java.util.List;

/**
 * @author Tomasz Dębski
 *
 */
public interface BookReaderService {

BookReader getBookReaderbyId(long id);
	
	List<BookReader> getAllBookReader();
	
	void addBookReader(BookReader bookReader);
	
	void updateBookReader(BookReader bookReader);
	
	void removeBookReader(BookReader bookReader);

	BookReader getBookReaderByUsername(String username);
	
	
}

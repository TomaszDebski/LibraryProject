package com.library.services.impl;

import java.util.List;

import com.library.dao.BookReaderDao;
import com.library.entities.BookReader;
import com.library.services.BookReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tomasz Dębski
 *
 */
@Service
public class BookReaderServiceImpl implements BookReaderService {
	
	@Autowired
	BookReaderDao bookReaderDao;

	@Override
	public BookReader getBookReaderbyId(long id) {
		return bookReaderDao.getBookReaderbyId(id);
	}

	@Override
	public List<BookReader> getAllBookReader() {
		return bookReaderDao.getAllBookReader();
	}

	@Override
	public void addBookReader(BookReader bookReader) {
		if (bookReader.getRole() == null){
			bookReader.setRole("ROLE_USER");
		}
		bookReaderDao.addBookReader(bookReader);
	}

	@Override
	public void updateBookReader(BookReader book) {
		bookReaderDao.updateBookReader(book);
	}

	@Override
	public void removeBookReader(BookReader book) {
		bookReaderDao.removeBookReader(book);
	}

	@Override
	public List<BookReader> getAllBookReaderGraph() {
		return bookReaderDao.getAllBookReaderGraph();
	}

	@Override
	public BookReader getBookReaderByUsername(String username) {
		return bookReaderDao.getBookReaderByUsername(username);
	}


}

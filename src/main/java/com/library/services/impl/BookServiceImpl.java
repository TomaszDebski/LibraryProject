package com.library.services.impl;

import java.util.List;

import com.library.dao.BookDao;
import com.library.entities.Book;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao bookDao;

	@Override
	public Book getBookbyId(long id) {
		return bookDao.getBookbyId(id);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public void removeBook(Book book) {
		bookDao.removeBook(book);
	}

	@Override
	public List<Book> getAllBooksWithoutId() {
		return bookDao.getAllBooksWithoutId();
	}

	@Override
	public List<Book> getAllBooksForBookReaderByName(String name){
		return bookDao.getAllBooksForBookReaderByName(name);
	}

}

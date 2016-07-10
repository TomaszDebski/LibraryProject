package com.library.controllers;

import java.util.List;

import com.library.entities.Book;
import com.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tomasz Dębski
 *
 */
@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/book")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}

	@RequestMapping(value = "/book",method= RequestMethod.POST)
	public void addBook(@RequestBody Book book){
		bookService.addBook(book);
	}
	
	@RequestMapping(value="/book/{id}")
	public Book getBookById(@PathVariable("id") long id){
		return bookService.getBookbyId(id);
	}
	
	@RequestMapping(value="/book/{id}",method=RequestMethod.PUT)
	public void updateBook(@PathVariable("id") long id,@RequestBody Book book){	
		bookService.updateBook(book);
	}
	
	@RequestMapping(value="/book/{id}",method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") long id){
		Book book = bookService.getBookbyId(id);
		bookService.removeBook(book);
	}
	
	@RequestMapping(value="/bookWithoutId")
	public List<Book> getAllBooksWithoutId(){
		return bookService.getAllBooksWithoutId();
	}
	
	@RequestMapping(value="/bookReaderBooks/{bookReaderName}")
	public List<Book> getAllBooksOneBookReader(@PathVariable String bookReaderName){
		return bookService.getAllBooksForBookReaderByName(bookReaderName);
	}
}

package com.library;

import com.library.entities.Book;
import com.library.entities.BookReader;
import com.library.entities.OrderPack;
import com.library.services.BookReaderService;
import com.library.services.BookService;
import com.library.services.OrderPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author Tomasz Dębski
 *
 */
@SpringBootApplication
public class LibraryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryProjectApplication.class, args);
	}

	@Autowired
	private BookReaderService bookReaderService;

	@Autowired
	private OrderPackService orderPackService;

	@Autowired
	private BookService bookService;

	@PostConstruct
	public void setup(){
		BookReader bookReader1 = new BookReader();
		bookReader1.setReaderName("user");
		bookReader1.setPassword("user");
		bookReader1.setRole("ROLE_USER");
		bookReaderService.addBookReader(bookReader1);
		BookReader bookReader2 = new BookReader();
		bookReader2.setReaderName("admin");
		bookReader2.setPassword("admin");
		bookReader2.setRole("ROLE_ADMIN");
		bookReaderService.addBookReader(bookReader2);
		OrderPack orderPack1 = new OrderPack();
		orderPack1.setBorrowDate(new Date());
		orderPack1.setBookReader(bookReader1);
		orderPackService.addOrderPack(orderPack1);
		Book book1 = new Book();
		book1.setAvailable(false);
		book1.setBookBorrowDate(new Date());
		book1.setReturnDateBook(new Date());
		book1.setCategory("fiction");
		book1.setTitle("1984");
		book1.setAuthor("George Orwell");
		book1.setOrderPack(orderPack1);
		bookService.addBook(book1);
		Book book2 = new Book();
		book2.setAvailable(false);
		book2.setBookBorrowDate(new Date());
		book2.setReturnDateBook(new Date());
		book2.setCategory("fiction");
		book2.setTitle("The Da Vinci Code");
		book2.setAuthor("Dan Brown");
		book2.setOrderPack(orderPack1);
		bookService.addBook(book2);
		Book book3 = new Book();
		book3.setAvailable(true);
		book3.setCategory("fiction");
		book3.setTitle("The Hobbit");
		book3.setAuthor("J.R.R. Tolkien");
		bookService.addBook(book3);
		Book book4 = new Book();
		book4.setAvailable(true);
		book4.setCategory("documentary");
		book4.setTitle("Steve Jobs");
		book4.setAuthor("Walter Isaacson");
		bookService.addBook(book4);
		Book book5 = new Book();
		book5.setAvailable(true);
		book5.setCategory("documentary");
		book5.setTitle("Eat, Pray, Love");
		book5.setAuthor("Elizabeth Gilbert");
		bookService.addBook(book5);
	}
}

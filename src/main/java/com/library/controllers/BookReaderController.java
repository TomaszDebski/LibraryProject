package com.library.controllers;

import java.util.List;

import com.library.entities.BookReader;
import com.library.services.BookReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tomasz Dębski
 *
 */
@RestController
public class BookReaderController {
	
	@Autowired
	BookReaderService bookReaderService;
	
	@RequestMapping(value= "/bookReader",method=RequestMethod.POST)
	public void addReader(@RequestBody BookReader bookReader){
		bookReaderService.addBookReader(bookReader);
	}
	
	@RequestMapping(value="/bookReader")
	public List<BookReader> getAllBookReader(){
		return bookReaderService.getAllBookReader();
//		return bookReaderService.
	}
	
	@RequestMapping(value="/bookReader/{id}")
	public BookReader getOneBookReader(@PathVariable("id") long id){
		return bookReaderService.getBookReaderbyId(id);
	}
	
	@RequestMapping(value="/bookReader/{id}",method=RequestMethod.PUT)
	public void updateBookReader(@PathVariable("id") long id,@RequestBody BookReader bookReader){	
		bookReaderService.updateBookReader(bookReader);
	}
	
	@RequestMapping(value="/bookReader/{id}",method=RequestMethod.DELETE)
	public void deleteBookReader(@PathVariable("id") long id){
		BookReader bookReaderbyId = bookReaderService.getBookReaderbyId(id);
		bookReaderService.removeBookReader(bookReaderbyId);
	}
	
	@RequestMapping(value="/bookReader/getAll")
	public List<BookReader> getAllBookReaderGraph(){
		return bookReaderService.getAllBookReaderGraph();
	}
	
	@RequestMapping(value="/bookReaders/{bookReaderName}")
	public BookReader getBookReaderByUsername(@PathVariable String bookReaderName){
		return bookReaderService.getBookReaderByUsername(bookReaderName);
	}
	
//	@RequestMapping("/isAvailable")
//	public String isAvailable(@RequestParam String username) {
//		Boolean available = bookReaderService.getBookReaderByUsername(username) == null;
//		System.out.println("is available" + available);
//		return available.toString();
//	}
	

}

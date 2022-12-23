package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.repository.CustomerRepository;
import com.example.service.BookService;


@RestController
public class BookController {
	@Autowired
	public BookService bookService;
	@Autowired
	private BookRepository bookRepository;
	public CustomerRepository customerRepository; 
	
	// add a book
	
	@PostMapping(value = "/books")
	public String addController(@RequestBody  Book book) {
	    book= bookRepository.save(book);
		System.out.println(book.getB_Name());
		System.out.println(book.getCustomer().getC_Email());
		return "getting";
		
	}

    // get all book
	
	@GetMapping(value = "/books")
	public List<Book> getAllController() {
		return bookService.getAllBooks();
	}

	// update a book
	
	@PutMapping(value = "/books/{id}")
	public Book updateController(@PathVariable int id, @RequestBody Book book) {
		return bookService.updateBook(book, id);
	}

	// delete a book

	@DeleteMapping(value = "/books/{id}")
	public String deleteController(@PathVariable int id) {
		return bookService.deleteBook(id);
	}

	
	 
}

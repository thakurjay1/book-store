package com.book.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.model.Book;
import com.book.store.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@GetMapping("/search")
	public List<Book> searchBooks(@RequestParam String title, @RequestParam String author) {
		System.out.println("Initiated Searching Books");
		return bookService.searchBooks(title, author);
	}

	@GetMapping
	public Page<Book> getAllBooks(@RequestParam int page, @RequestParam int size) {
		Pageable pageable = PageRequest.of(page, size);
		System.out.println("Getting All Books");
		return bookService.getAllBooks(pageable);
	}

	@DeleteMapping("/{isbn}")
	public HttpStatus deleteBook(@PathVariable String isbn) {
		System.out.println("Deletings books by isbn number");
		bookService.deleteBook(isbn);
		return HttpStatus.NO_CONTENT;
	}
}

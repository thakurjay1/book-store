package com.book.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.book.store.model.Book;
import com.book.store.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> searchBooks(String title, String author) {
		return bookRepository.findByTitleContainingOrAuthorContaining(title, author);
	}

	@Override
	public Page<Book> getAllBooks(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@Override
	public void deleteBook(String isbn) {
		bookRepository.deleteById(Long.valueOf(isbn));
	}

}

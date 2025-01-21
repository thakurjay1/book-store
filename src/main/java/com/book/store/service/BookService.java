package com.book.store.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.book.store.model.Book;

public interface BookService {
	Book addBook(Book book);
    List<Book> searchBooks(String title, String author);
    Page<Book> getAllBooks(Pageable pageable);
    void deleteBook(String isbn);
}

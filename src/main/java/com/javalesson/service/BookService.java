package com.javalesson.service;

import com.javalesson.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(int id);
    void updateBook(Book book);
    void deleteBook(int id);
}

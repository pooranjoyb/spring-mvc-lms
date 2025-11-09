package com.javalesson.controller;

import com.javalesson.model.Book;
import com.javalesson.service.BookService;
import com.javalesson.service.BookServiceImpl;

import java.util.List;

public class BookController {
    private final BookService bookService;

    public BookController () {
        this.bookService = new BookServiceImpl();
    }

    public void addBook(Book book) {
        this.bookService.addBook(book);
    }

    public Book getBookById(int id) {
        return this.bookService.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    public void updateBook(Book book){
        this.bookService.updateBook(book);
    }

    public void deleteBook(int id) {
        this.bookService.deleteBook(id);
    }
}

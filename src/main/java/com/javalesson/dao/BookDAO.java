package com.javalesson.dao;

import com.javalesson.model.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(int id);
//    void updateBook(Book book);
//    void deleteBook(int id);
}

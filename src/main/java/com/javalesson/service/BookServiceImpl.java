package com.javalesson.service;

import com.javalesson.dao.BookDAO;
import com.javalesson.dao.BookDAOImpl;
import com.javalesson.model.Book;
import com.javalesson.util.BookValidator;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;

    public BookServiceImpl() {
        this.bookDAO = new BookDAOImpl();
    }

    @Override
    public void addBook(Book book) {
        if(BookValidator.validateTitle(book.getTitle())) {
            bookDAO.addBook(book);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookDAO.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return this.bookDAO.getBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        this.bookDAO.updateBook(book);
    }

    @Override
    public void deleteBook(int id) {
        this.bookDAO.deleteBook(id);
    }
}

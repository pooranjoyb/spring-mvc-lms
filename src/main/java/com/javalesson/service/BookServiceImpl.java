package com.javalesson.service;

import com.javalesson.dao.BookDAO;
import com.javalesson.dao.BookDAOImpl;
import com.javalesson.model.Book;
import com.javalesson.util.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookDAO bookDAO;

    public BookServiceImpl() {
        this.bookDAO = new BookDAOImpl();
    }

    @Override
    public void addBook(Book book) {
        // example business logic/validations
        if (BookValidator.validateTitle(book.getTitle())) {
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

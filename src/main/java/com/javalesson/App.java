package com.javalesson;

import com.javalesson.model.Book;
import com.javalesson.service.BookService;
import com.javalesson.service.BookServiceImpl;

import java.util.List;

/**
 * Main target point
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BookService dao = new BookServiceImpl();
        Book book = new Book(2, "Thousand Splendid suns", "Kalid", true);
        dao.addBook(book);

        Book bookWithId = dao.getBookById(1);
        System.out.println("Book : " + bookWithId);

        List<Book> allBooks = dao.getAllBooks();
        for (Book b : allBooks) {
            System.out.println(b);
        }
    }
}

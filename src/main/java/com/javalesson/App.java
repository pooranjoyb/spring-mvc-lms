package com.javalesson;

import com.javalesson.dao.BookDAO;
import com.javalesson.dao.BookDAOImpl;
import com.javalesson.model.Book;
import java.util.List;

/**
 * Main target point
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BookDAO dao = new BookDAOImpl();
        Book book = new Book(1, "The Alchemist", "Paolo Coelho", true);
        dao.addBook(book);

        Book bookWithId = dao.getBookById(1);
        System.out.println("Book : " + bookWithId);

        List<Book> allBooks = dao.getAllBooks();
        for (Book b : allBooks) {
            System.out.println(b);
        }
    }
}

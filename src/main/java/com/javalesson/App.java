package com.javalesson;

import com.javalesson.config.AppConfig;
import com.javalesson.controller.BookController;
import com.javalesson.model.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Main target point
 *
 */
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(AppConfig.class);

        BookController controller = cxt.getBean(BookController.class);
//        Book book = new Book(2, "Thousand Splendid suns", "Khalid", true);
//        controller.addBook(book);

        Book bookWithId = controller.getBookById(1);
        System.out.println("Book : " + bookWithId);

        List<Book> allBooks = controller.getAllBooks();
        for (Book b : allBooks) {
            System.out.println(b);
        }
    }
}

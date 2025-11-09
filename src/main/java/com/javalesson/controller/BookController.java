package com.javalesson.controller;

import com.javalesson.model.Book;
import com.javalesson.service.BookService;
import com.javalesson.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController () {
        this.bookService = new BookServiceImpl();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        this.bookService.addBook(book);
    }

    @GetMapping("/{id")
    public Book getBookById(@PathVariable int id) {
        return this.bookService.getBookById(id);
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PutMapping("/{id")
    public void updateBook(@PathVariable int id, @RequestBody Book book){
        // this is needed, we need to first set the requested id to the book and then call service
        book.setId(id);
        this.bookService.updateBook(book);
    }

    @DeleteMapping("/{id")
    public void deleteBook(@PathVariable int id) {
        this.bookService.deleteBook(id);
    }
}

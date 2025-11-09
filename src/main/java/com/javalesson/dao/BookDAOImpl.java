package com.javalesson.dao;

import com.javalesson.model.Book;
import com.javalesson.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    private final Connection connection;

    public BookDAOImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addBook(Book book) {
        String query = "INSERT into BOOKS (title, author, available) VALUES (?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setBoolean(3, book.isAvailable());
            pstmt.executeUpdate();
            System.out.println("Book added successfully");
        } catch (SQLException e) {
            System.out.println("Book add failed");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        String query = "select * from books";

        try (PreparedStatement ptsmt = connection.prepareStatement(query)) {
            ResultSet rs = ptsmt.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available")
                );
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch book list" + e);
        }

        return bookList;
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        String query = "select * from books where ID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available")
                );
            }
        } catch (SQLException e) {
            System.out.println("book fetched with id");
        }
        return book;
    }


}

package com.javalesson.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static final String URL = "jdbc:postgresql://localhost:5434/librarymvc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connected to PostgreSQL database successfully!");
            } catch (SQLException e) {
                System.out.println("Connection failed: " + e.getMessage());
            }
        }
        return connection;
    }

}

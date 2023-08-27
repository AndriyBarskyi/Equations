package com.example.equations.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private DatabaseInitializer() {

    }

    public static void createTables() {
        try (Connection connection = DatabaseManager.getConnection();
            Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS equations ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "equation VARCHAR(255) NOT NULL UNIQUE ,"
                + "roots VARCHAR(255) NOT NULL);";
            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create tables.");
        }
    }
}


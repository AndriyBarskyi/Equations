package com.example.equations.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    // Параметри підключення до бази даних (змініть їх на ваші дані)
    private static final String DB_URL =
        "jdbc:mysql://localhost:3306/equations";
    private static final String DB_USER = "MyUser";
    private static final String DB_PASSWORD = "TeST-PaSSWoRD123!";
    private static Connection connection;
    private DatabaseManager() {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}


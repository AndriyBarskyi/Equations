package com.example.equations.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private DatabaseManager() {
    }

    private static Connection connection;
    private static final String DB_URL = DBConfig.getDbUrl();
    private static final String DB_USER = DBConfig.getDbUsername();
    private static final String DB_PASSWORD = DBConfig.getDbPassword();


    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}


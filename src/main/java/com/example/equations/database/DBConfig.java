package com.example.equations.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConfig {

    private static final String PROPERTIES_FILE = "database.properties";
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = DBConfig.class.getClassLoader()
            .getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            Logger.getLogger(DBConfig.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private DBConfig() {

    }

    public static String getDbUrl() {
        return properties.getProperty("db.url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }
}


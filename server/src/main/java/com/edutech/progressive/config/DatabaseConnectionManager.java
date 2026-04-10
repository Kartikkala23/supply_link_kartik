package com.edutech.progressive.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

   
    private static Properties properties;

    public static void loadProperties() {
        properties = new Properties();
        try (InputStream input = DatabaseConnectionManager.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            
            if (input == null) {
                throw new RuntimeException("application.properties file not found.");
            }
            properties.load(input);
            
        } catch (IOException e) {
            throw new RuntimeException("Error reading application.properties file.", e);
        }
    }

    
    public static Connection getConnection() throws SQLException {
        if (properties == null) {
            loadProperties();
        }

        
        String url = properties.getProperty("spring.datasource.url");
        String user = properties.getProperty("spring.datasource.username");
        String password = properties.getProperty("spring.datasource.password");

        return DriverManager.getConnection(url, user, password);
    }
}
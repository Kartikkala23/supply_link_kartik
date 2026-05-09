package com.edutech.progressive.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnectionManager {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    public static void loadProperties() {
        try (InputStream input = DatabaseConnectionManager.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find application.properties");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading database configuration", e);
        }
    }

    // new database connection using DriverManager.
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    properties.getProperty("spring.datasource.url"),
                    properties.getProperty("spring.datasource.username"),
                    properties.getProperty("spring.datasource.password"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to establish database connection", e);
        }
    }
}

/*
 * 
 * 1. Supplier Table
 * CREATE TABLE supplier (
 * supplier_id INT AUTO_INCREMENT PRIMARY KEY,
 * supplier_name VARCHAR(100) NOT NULL,
 * email VARCHAR(100) NOT NULL,
 * username VARCHAR(255) NOT NULL,
 * password VARCHAR(255) NOT NULL,
 * phone VARCHAR(20),
 * address VARCHAR(255),
 * role VARCHAR(50)
 * );
 * 
 * 2. Warehouse Table
 * CREATE TABLE warehouse (
 * warehouse_id INT PRIMARY KEY AUTO_INCREMENT,
 * supplier_id INT NOT NULL,
 * warehouse_name VARCHAR(100) NOT NULL,
 * location VARCHAR(255) NOT NULL,
 * capacity INT NOT NULL
 * );
 * 
 * 3. Product Table
 * CREATE TABLE product (
 * product_id INT PRIMARY KEY AUTO_INCREMENT,
 * warehouse_id INT NOT NULL,
 * product_name VARCHAR(100) NOT NULL,
 * product_description TEXT,
 * quantity INT NOT NULL,
 * price DECIMAL(10, 2) NOT NULL
 * );
 * 
 * 
 */
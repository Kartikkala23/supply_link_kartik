package com.edutech.progressive.service;

import com.edutech.progressive.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    List<Product> getAllProducts() throws SQLException;

    Product getProductById(int productId) throws SQLException;

    int addProduct(Product product) throws SQLException;

    void updateProduct(Product product) throws SQLException;

    void deleteProduct(int productId) throws SQLException;

    // Do not implement this method in ProductServiceImplJdbc.java
    public default List<Product> getAllProductByWarehouse(int warehouseId) throws SQLException{
        return null;
    }
}
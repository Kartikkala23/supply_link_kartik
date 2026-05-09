package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.edutech.progressive.dao.ProductDAO;
import com.edutech.progressive.entity.Product;
import com.edutech.progressive.service.ProductService;

public class ProductServiceImplJdbc implements ProductService {
    private ProductDAO productDAO;

    public ProductServiceImplJdbc(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        try {
            return productDAO.getAllProducts();
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        try {
            return productDAO.getProductById(productId);
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }

    @Override
    public int addProduct(Product product) throws SQLException {
        try {
            return productDAO.addProduct(product);
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        try {
            productDAO.updateProduct(product);
        } catch (SQLException e) {
            throw e;
        } finally {

        }
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        try {
            productDAO.deleteProduct(productId);
        } catch (SQLException e) {
            throw e;
        } finally {
        }
    }

}
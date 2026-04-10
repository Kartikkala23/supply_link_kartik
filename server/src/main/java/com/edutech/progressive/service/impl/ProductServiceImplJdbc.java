package com.edutech.progressive.service.impl;

import com.edutech.progressive.dao.ProductDAO;
import com.edutech.progressive.entity.Product;
import com.edutech.progressive.service.ProductService;
import java.util.List;

public class ProductServiceImplJdbc implements ProductService {
    private ProductDAO productDAO;

    public ProductServiceImplJdbc(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    @Override
    public int addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }
}

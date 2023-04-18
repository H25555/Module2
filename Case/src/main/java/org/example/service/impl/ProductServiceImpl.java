package org.example.service.impl;

import org.example.model.Product;

import java.util.List;

public interface ProductServiceImpl {
    List<Product> getListProduct();
    Product getProductDetail(int productId);
    void add(Product newProduct);
    boolean update(int productId, Product updtProduct);
    boolean delete(int productId);
}

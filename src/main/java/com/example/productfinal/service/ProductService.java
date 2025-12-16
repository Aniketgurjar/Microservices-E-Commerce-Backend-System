package com.example.productfinal.service;

import com.example.productfinal.Exceptions.InvalidProductIdException;
import com.example.productfinal.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(Long id) throws InvalidProductIdException;
    List<Product> getAllProducts();
    Product updateProduct(Long id,Product product);
    Product createProduct(Product product);
    void deleteProduct();
}

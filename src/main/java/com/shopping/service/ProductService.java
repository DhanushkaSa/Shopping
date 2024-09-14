package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.entity.Product;

@Service
public interface ProductService {

    public Product createProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProduct(Long productId);

    public Product updateProduct(Long productId, Product product);

    public void deleteProduct(Long productId);
}

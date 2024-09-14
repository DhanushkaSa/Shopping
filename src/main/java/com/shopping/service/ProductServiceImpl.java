package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Product;
import com.shopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        Product updateProduct=productRepository.findById(productId).orElse(null);
        if(updateProduct==null){
            return null;
        }else{
            updateProduct.setName(product.getName());
            updateProduct.setDescription(product.getDescription());
            updateProduct.setPrice(product.getPrice());
            updateProduct.setCategory(product.getCategory());
            return productRepository.save(updateProduct);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
    
}

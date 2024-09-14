package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.DTO.ProductDto;
import com.shopping.entity.Category;
import com.shopping.entity.Product;
import com.shopping.service.CategoryService;
import com.shopping.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.status(200).body(productService.getAllProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
        if (productDto.getName() == null) {
            return ResponseEntity.status(400).body("product name is null");
        }

        if (productDto.getDescription() == null) {
            return ResponseEntity.status(400).body("product description is null");
        } else {
            Product product = new Product();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());

            Category category = categoryService.getCategory(productDto.getCategoryId());
            product.setCategory(category);
            return ResponseEntity.status(201).body(productService.createProduct(product));
        }

    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {

        Product product = productService.getProduct(productId);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        Category category = categoryService.getCategory(productDto.getCategoryId());
        product.setCategory(category);
        return ResponseEntity.status(200).body(productService.updateProduct(productId, product));

    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId) {
        Product product = productService.getProduct(productId);
        if (product == null) {
            return ResponseEntity.status(404).body("Product not found");
        } else {
            return ResponseEntity.status(200).body(product);
        }
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}

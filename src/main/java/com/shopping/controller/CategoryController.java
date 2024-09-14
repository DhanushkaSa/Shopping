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

import com.shopping.entity.Category;
import com.shopping.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.status(200).body(categoryService.getAllCategories());
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable Long categoryId) {
        Category category = categoryService.getCategory(categoryId);
        if (category == null) {
            return ResponseEntity.status(404).body("Category not found");
        } else {
            return ResponseEntity.status(200).body(category);
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        if (category.getName() != null) {
            return ResponseEntity.status(201).body(categoryService.createCategory(category));
        } else {
            return ResponseEntity.status(400).body("Category null value");
        }

    }

    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<?> updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
        Category updateCategory = categoryService.updateCategory(categoryId, category);
        if (updateCategory == null) {
            return ResponseEntity.status(404).body("Category not found");
        } else {
            return ResponseEntity.status(200).body(updateCategory);
        }
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}

package com.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopping.entity.Category;

@Service
public interface CategoryService {
    
    public List<Category> getAllCategories();

    public Category getCategory(Long categoryId);

    public Category createCategory(Category category);

    public Category updateCategory(Long categoryId,Category category);

    public void deleteCategory(Long categoryId);
}

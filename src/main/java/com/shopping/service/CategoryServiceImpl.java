package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.Category;
import com.shopping.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
        Category updateCategory=categoryRepository.findById(categoryId).orElse(null);
        if(updateCategory==null){
            return null;
        }else{
            updateCategory.setName(category.getName());
            Category update=categoryRepository.save(updateCategory);
            return update;
        }
    }

    @Override
    public void deleteCategory(Long categoryId) {
       categoryRepository.deleteById(categoryId);
    }

   
    
}

package com.tushar.blog.services;

import com.tushar.blog.model.Category;
import com.tushar.blog.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public Category getCategoryById(int id) {
        return categoryRepo.findById(id).get();

    }
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();

    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }
    public Category updateCategory(Category category) {
        return categoryRepo.save(category);
    }
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }
}

package com.tushar.blog.controllers;

import com.tushar.blog.model.Category;
import com.tushar.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
        @Autowired
        private CategoryService categoryService;

        @PostMapping("/")
        public ResponseEntity<Category> createCategory(@RequestBody Category category) {
            categoryService.saveCategory(category);
            return ResponseEntity.ok(category);
        }

        @PutMapping("/")
        public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
            categoryService.updateCategory(category);
            return ResponseEntity.ok(category);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
            return ResponseEntity.ok(categoryService.getCategoryById(id));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteCategoryById(@PathVariable Integer id) {
            categoryService.deleteCategory(id);
            return ResponseEntity.ok("ITEM DELETED");
        }

        @GetMapping("/")
        public ResponseEntity<List<Category>> getCategories() {
            return ResponseEntity.ok(categoryService.getAllCategories());
        }
    }

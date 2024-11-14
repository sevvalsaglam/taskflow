package com.workintech.taskflow.service;

import com.workintech.taskflow.entity.Category;
import com.workintech.taskflow.exception.ApiException;
import com.workintech.taskflow.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ApiException("Category not found", HttpStatus.NOT_FOUND));
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = findCategoryById(id);
        category.setName(categoryDetails.getName());
        // Diğer alanlar burada güncellenebilir
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = findCategoryById(id);
        categoryRepository.delete(category);
    }
}


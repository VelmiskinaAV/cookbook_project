package ru.mrsu.cookbook.service;

import ru.mrsu.cookbook.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(Long id);
    void setCategory(String categoryName);
}

package ru.mrsu.cookbook.controller;

import org.springframework.web.bind.annotation.*;
import ru.mrsu.cookbook.model.Category;
import ru.mrsu.cookbook.service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("internal/api/v1/categories")
    List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/api/v1/category/{categoryName}")
    void setCategory(@PathVariable("categoryName") String categoryName) {
        categoryService.setCategory(categoryName);
    }

    @GetMapping("internal/api/v1/category/{id}")
    Category getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

}

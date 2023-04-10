package ru.mrsu.cookbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mrsu.cookbook.model.Category;
import ru.mrsu.cookbook.service.CategoryService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("internal/api/v1/categories")
    ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PostMapping("/api/v1/category/{categoryName}")
    void setCategory(@PathVariable("categoryName") String categoryName) {
        categoryService.setCategory(categoryName);
    }

    @GetMapping("internal/api/v1/category/{id}")
    ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

}

package ru.mrsu.cookbook.service.impl;

import org.springframework.stereotype.Service;
import ru.mrsu.cookbook.exception.NotFoundApiException;
import ru.mrsu.cookbook.model.Category;
import ru.mrsu.cookbook.repository.CategoryRepository;
import ru.mrsu.cookbook.service.CategoryService;

import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new RuntimeException();
        }
        return categories;
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryRepository.findCategoriesById(id).orElse(null);
        if (Objects.isNull(category)) {
            throw NotFoundApiException.Builder.notFoundApiException().build();
        }
        return category;
    }

    @Override
    public void setCategory(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        categoryRepository.save(category);
    }
}

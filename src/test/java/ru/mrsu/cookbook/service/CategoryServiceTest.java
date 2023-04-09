package ru.mrsu.cookbook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import ru.mrsu.cookbook.config.ContainerBase;
import ru.mrsu.cookbook.exception.NotFoundApiException;
import ru.mrsu.cookbook.model.Category;
import ru.mrsu.cookbook.repository.CategoryRepository;
import ru.mrsu.cookbook.service.impl.CategoryServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Import(CategoryServiceImpl.class)
public class CategoryServiceTest extends ContainerBase {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @BeforeEach
    void initDb() {
        categoryRepository.saveAll(List.of(
                new Category(1L, "category1"),
                new Category(2L, "category2"),
                new Category(3L, "category3")
        ));
    }

    @Test
    void getCategoryByIdTest() {
        Category category = categoryService.getCategoryById(1L);
        assertEquals(category.getId(), 1L);
        assertEquals(category.getName(), "category1");
    }

    @Test
    void getCategoryByIdNotFoundTest() {
        assertThrows(NotFoundApiException.class,
                () -> categoryService.getCategoryById(5L));
    }
}

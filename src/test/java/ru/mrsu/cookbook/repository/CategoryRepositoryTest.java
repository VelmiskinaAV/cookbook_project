package ru.mrsu.cookbook.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.mrsu.cookbook.config.ContainerBase;
import ru.mrsu.cookbook.model.Category;
import ru.mrsu.cookbook.repository.CategoryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CategoryRepositoryTest extends ContainerBase {

    @Autowired
    CategoryRepository categoryRepository;

//    @Test
//    void checkContainerTest() {
//        Assertions.assertEquals(0, categoryRepository.findAll().size());
//    }

    @BeforeEach
    void initDb() {
        categoryRepository.saveAll(List.of(
                new Category(1L, "category1"),
                new Category(2L, "category2"),
                new Category(3L, "category3")
                ));

    }
    @Test
    void findCategoriesByIdTest() {
        assertEquals(3, categoryRepository.findAll().size());
        Category category = categoryRepository.findCategoriesById(2L).orElse(null);
        assertEquals(2L, category.getId());
        assertEquals("category2", category.getName());

    }

    @Test
    void findCategoriesByIdNotFoundTest() {
        Category category = categoryRepository.findCategoriesById(5L).orElse(null);
        assertNull(category);
    }
}

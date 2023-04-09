package ru.mrsu.cookbook.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.mrsu.cookbook.exception.NotFoundApiException;
import ru.mrsu.cookbook.model.Category;
import ru.mrsu.cookbook.repository.CategoryRepository;
import ru.mrsu.cookbook.service.impl.CategoryServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith({SpringExtension.class})
@Import({CategoryServiceImpl.class})
public class CategoryServiceMockRepositoryTest {

    @MockBean
    public CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @BeforeEach
    void initDb() {
        when(categoryRepository.findCategoriesById(1L)).thenReturn(Optional.of(new Category(1L, "category1")));
        when(categoryRepository.findCategoriesById(5L)).thenThrow(NotFoundApiException.class);
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

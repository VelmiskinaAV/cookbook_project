package ru.mrsu.cookbook.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.mrsu.handler.exception.NotFoundApiException;
import ru.mrsu.cookbook.model.Category;
import ru.mrsu.cookbook.repository.CategoryRepository;
import ru.mrsu.cookbook.service.CategoryService;
import ru.mrsu.cookbook.service.impl.CategoryServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
@ExtendWith(SpringExtension.class)
@Import({CategoryServiceImpl.class})
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;

    @Test
    public void loadContext() {}

    @BeforeEach
    void initDb() {
        when(categoryRepository.findCategoriesById(1L)).thenReturn(Optional.of(new Category(1L, "category1")));
        when(categoryRepository.findCategoriesById(5L)).thenThrow(NotFoundApiException.class);
    }



    @Test
    void findCategoryByIdStatusIsOk() throws Exception {
        mvc.perform(get("/internal/api/v1/category/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("category1"))
                .andDo(print());
    }

    @Test
    void findCategoryByIdStatusIsNotFound() throws Exception {
        mvc.perform(get("/internal/api/v1/category/{id}", 5L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

}

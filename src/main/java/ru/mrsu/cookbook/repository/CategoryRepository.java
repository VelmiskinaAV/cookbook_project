package ru.mrsu.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mrsu.cookbook.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoriesById(Long id);
}

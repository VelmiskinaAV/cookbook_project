package ru.mrsu.cookbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mrsu.cookbook.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(String id);
}

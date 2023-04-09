package ru.mrsu.cookbook.service;

import ru.mrsu.cookbook.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();
    void setAuthor(Author author);
    Author getAuthorById(String id);
}

package ru.mrsu.cookbook.controller;

import org.springframework.web.bind.annotation.*;
import ru.mrsu.cookbook.model.Author;
import ru.mrsu.cookbook.service.AuthorService;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("internal/api/v1/authors")
    List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @PostMapping("/api/v1/author")
    void setAuthor(@RequestBody Author author) {
        authorService.setAuthor(author);
    }

    @GetMapping("internal/api/v1/author/{id}")
    Author getAuthorById(@PathVariable("id") String id) {
        return authorService.getAuthorById(id);
    }
}

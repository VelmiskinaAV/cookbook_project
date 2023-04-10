package ru.mrsu.cookbook.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mrsu.cookbook.model.Author;
import ru.mrsu.cookbook.service.AuthorService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("internal/api/v1/authors")
    ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok(authorService.getAuthors());
    }

    @PostMapping("/api/v1/author")
    void setAuthor(@RequestBody Author author) {
        authorService.setAuthor(author);
    }

    @GetMapping("internal/api/v1/author/{id}")
    ResponseEntity<Author> getAuthorById(@PathVariable("id") String id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }
}

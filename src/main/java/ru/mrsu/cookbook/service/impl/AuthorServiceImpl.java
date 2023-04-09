package ru.mrsu.cookbook.service.impl;

import org.springframework.stereotype.Service;
import ru.mrsu.cookbook.model.Author;
import ru.mrsu.cookbook.repository.AuthorRepository;
import ru.mrsu.cookbook.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public void setAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(String id) {
        return authorRepository.findAuthorById(id);
    }

}

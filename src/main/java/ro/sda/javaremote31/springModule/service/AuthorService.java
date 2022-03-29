package ro.sda.javaremote31.springModule.service;

import org.springframework.stereotype.Service;
import ro.sda.javaremote31.springModule.entities.Author;
import ro.sda.javaremote31.springModule.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }


}

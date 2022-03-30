package ro.sda.javaremote31.springModule.service;

import org.springframework.stereotype.Service;
import ro.sda.javaremote31.springModule.entities.Author;
import ro.sda.javaremote31.springModule.entities.Book;
import ro.sda.javaremote31.springModule.errors.EntityNotFoundError;
import ro.sda.javaremote31.springModule.mappers.AuthorMapper;
import ro.sda.javaremote31.springModule.model.AuthorForm;
import ro.sda.javaremote31.springModule.model.BookForm;
import ro.sda.javaremote31.springModule.repository.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void createAuthor(AuthorForm form) {
        Author author = authorMapper.convertToEntity(form);
        authorRepository.save(author);
    }

    public AuthorForm findById(long id) {
        Author entityAuthor = authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Book with %s does not exist", id)));
        return authorMapper.convertToDto(entityAuthor);
    }

    public void deleteById(long id) {
        authorRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Book with %s does not exist", id)));
        authorRepository.deleteById(id);
    }
}

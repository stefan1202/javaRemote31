package ro.sda.javaremote31.springModule.mappers;

import org.springframework.stereotype.Service;
import ro.sda.javaremote31.springModule.entities.Author;
import ro.sda.javaremote31.springModule.model.AuthorForm;
import ro.sda.javaremote31.springModule.repository.AuthorRepository;

@Service
public class AuthorMapper implements Mapper<Author, AuthorForm> {

    private final AuthorRepository authorRepository;

    public AuthorMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorForm convertToDto(Author entity) {
        AuthorForm authorForm = new AuthorForm();
        authorForm.setId(entity.getId());
        authorForm.setName(entity.getName());
        authorForm.setLastName(entity.getLastName());
        authorForm.setNationality(entity.getNationality());
        return authorForm;
    }

    @Override
    public Author convertToEntity(AuthorForm dto) {
        Author author;
        if (dto.getId() != null) { // din baza de date aducem o entitate sa lucram cu ea
            author = authorRepository.findById(dto.getId()).orElse(new Author());
        } else { // altfel se va creea alta
            author = new Author();
        }
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setLastName(dto.getLastName());
        author.setNationality(dto.getNationality());
        return author;
    }
}

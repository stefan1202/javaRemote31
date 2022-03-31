package ro.sda.javaremote31.springModule.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import ro.sda.javaremote31.springModule.entities.Author;
import ro.sda.javaremote31.springModule.entities.Book;
import ro.sda.javaremote31.springModule.model.BookForm;
import ro.sda.javaremote31.springModule.repository.AuthorRepository;
import ro.sda.javaremote31.springModule.repository.BookRepository;

@Service
public class BookMapper implements Mapper<Book, BookForm> {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public BookForm convertToDto(Book entity) {
        BookForm bookForm = new BookForm();
        bookForm.setId(entity.getId());
        if (entity.getAuthor()!= null) {
            bookForm.setAuthor(entity.getAuthor().getId());
        }
        bookForm.setTitle(entity.getTitle());
        bookForm.setType(entity.getType());
        bookForm.setPagesNumber(entity.getPagesNumber());
        return bookForm;
    }

    @Override
    public Book convertToEntity(BookForm dto) {
        Book book;
        if (dto.getId() != null) {
            book = bookRepository.findById(dto.getId()).orElse(new Book());
        } else {
            book = new Book();
        }
        book.setId(dto.getId());
        if (dto.getAuthor() !=null ) {
            Author author = authorRepository.getById(dto.getAuthor());
            book.setAuthor(author);
        }
        book.setTitle(dto.getTitle());
        book.setPagesNumber(dto.getPagesNumber());
        book.setType(dto.getType());
        return book;
    }
}

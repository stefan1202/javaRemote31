package ro.sda.javaremote31.springModule.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.javaremote31.springModule.entities.Book;
import ro.sda.javaremote31.springModule.model.BookForm;
import ro.sda.javaremote31.springModule.repository.BookRepository;

@Service
public class BookMapper implements Mapper<Book, BookForm> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookForm convertToDto(Book entity) {
        BookForm bookForm = new BookForm();
        bookForm.setId(entity.getId());
        bookForm.setAuthor(entity.getAuthor());
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
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setPagesNumber(dto.getPagesNumber());
        book.setType(dto.getType());
        return book;
    }
}

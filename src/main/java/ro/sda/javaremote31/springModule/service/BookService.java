package ro.sda.javaremote31.springModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ro.sda.javaremote31.springModule.entities.Book;
import ro.sda.javaremote31.springModule.errors.EntityNotFoundError;
import ro.sda.javaremote31.springModule.mappers.BookMapper;
import ro.sda.javaremote31.springModule.model.BookForm;
import ro.sda.javaremote31.springModule.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public void createBook(BookForm form) {
        Book book = bookMapper.convertToEntity(form);
        bookRepository.save(book);
    }

    public BookForm findById(int id) {
        Book entityBook = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Book with %s does not exist", id)));
        return bookMapper.convertToDto(entityBook);
    }

    public void deleteById(int id) {
        bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundError(String.format("Book with %s does not exist", id)));
        bookRepository.deleteById(id);
    }
}

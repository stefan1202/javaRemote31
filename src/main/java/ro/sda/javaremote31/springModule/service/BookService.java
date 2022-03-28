package ro.sda.javaremote31.springModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ro.sda.javaremote31.springModule.entities.Book;
import ro.sda.javaremote31.springModule.model.BookForm;
import ro.sda.javaremote31.springModule.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public void createBook(BookForm form) {
        Book book = new Book();
        book.setAuthor(form.getAuthor());
        book.setTitle(form.getTitle());
        book.setPagesNumber(form.getPagesNumber());
        book.setType(form.getType());
        bookRepository.save(book);
    }
}

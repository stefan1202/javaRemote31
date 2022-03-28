package ro.sda.javaremote31.springModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import ro.sda.javaremote31.springModule.entities.Book;
import ro.sda.javaremote31.springModule.errors.EntityNotFoundError;
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
        book.setId(form.getId());
        book.setAuthor(form.getAuthor());
        book.setTitle(form.getTitle());
        book.setPagesNumber(form.getPagesNumber());
        book.setType(form.getType());
        bookRepository.save(book);
    }

    public BookForm findById(int id) {

       Book entityBook= bookRepository.findById(id).orElseThrow(()->new EntityNotFoundError(String.format("Book with %s does not exist",id)));
       BookForm bookForm = new BookForm();
       bookForm.setId(entityBook.getId());
       bookForm.setAuthor(entityBook.getAuthor());
       bookForm.setTitle(entityBook.getTitle());
       bookForm.setType(entityBook.getType());
       bookForm.setPagesNumber(entityBook.getPagesNumber());
       return
               bookForm;
    }
}

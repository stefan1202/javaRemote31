package ro.sda.javaremote31.springModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaremote31.springModule.entities.Book;
import ro.sda.javaremote31.springModule.model.BookForm;
import ro.sda.javaremote31.springModule.service.AuthorService;
import ro.sda.javaremote31.springModule.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;


    @GetMapping("/books")
    public String showBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/create")
    public String showForm(Model model) {
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("bookForm", new BookForm());
        return "book_create";
    }

    @PostMapping("/books/create")
    public String createBook(@ModelAttribute("bookForm") @Valid BookForm form, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "book_create";
        }
        bookService.createBook(form);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{bookId}")
    public String showEditForm(@PathVariable("bookId") int id, Model model) {//Model e modelul din Spring MVC
        BookForm bookForm = bookService.findById(id);
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("bookForm", bookForm);
        return "book_create";
    }
    @GetMapping("/books/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id, Model model) {//Model e modelul din Spring MVC
       bookService.deleteById(id);
        return "redirect:/books";
    }
}

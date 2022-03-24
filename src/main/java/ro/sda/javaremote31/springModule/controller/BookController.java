package ro.sda.javaremote31.springModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.sda.javaremote31.springModule.entities.Book;
import ro.sda.javaremote31.springModule.model.BookForm;
import ro.sda.javaremote31.springModule.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    @ResponseBody
    public String showBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/create")
    @ResponseBody
    public String showForm(Model model) {
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
}

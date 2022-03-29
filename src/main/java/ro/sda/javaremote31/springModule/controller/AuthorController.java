package ro.sda.javaremote31.springModule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.javaremote31.springModule.entities.Author;
import ro.sda.javaremote31.springModule.service.AuthorService;

import java.util.List;

@Controller
public class AuthorController {

    private AuthorService authorService;

    @GetMapping("/authors")
    public String showAuthor(Model model) {
        List<Author> authorList = authorService.findAll();
        model.addAttribute("authors", authorList);
        return "authors";
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
}

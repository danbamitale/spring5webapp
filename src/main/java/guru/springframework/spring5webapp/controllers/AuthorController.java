package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository repository) {
        this.authorRepository = repository;
    }

    @RequestMapping("/authors")
    public String getAuthors(@NotNull Model model) {
        model.addAttribute("authors",  authorRepository.findAll());

        return "authors/list";
    }
}

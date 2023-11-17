package web.controller;


import java.util.List;
import model.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.impl.AuthorService;

@RestController
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/author/{id}")
    public Author loadAuthor(@PathVariable(name = "id") Long id) {
        return authorService.loadAuthor(id);
    }


    @GetMapping("/authors")
    public List<Author> loadAuthors() {
        return authorService.loadAllAuthors();
    }


    @PostMapping("/author")
    public void saveAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
    }

}

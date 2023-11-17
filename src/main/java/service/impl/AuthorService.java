package service.impl;


import java.util.List;
import model.Author;

public interface AuthorService {

    Author saveAuthor(Author author);

    Author loadAuthor(Long id);

    List<Author> loadAllAuthors();
}

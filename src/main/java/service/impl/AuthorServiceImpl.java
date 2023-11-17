package service.impl;


import java.util.ArrayList;
import java.util.List;
import model.Author;
import org.springframework.stereotype.Service;
import persistence.entity.AuthorEntity;
import persistence.repository.AuthorRepository;
import service.mapper.AuthorMapper;
import service.profile.ProfileLogger;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorMapper mapper;

    private final AuthorRepository repository;

    private final ProfileLogger profileLogger;


    public AuthorServiceImpl(AuthorMapper mapper, AuthorRepository repository, ProfileLogger profileLogger) {
        this.mapper = mapper;
        this.repository = repository;
        this.profileLogger = profileLogger;
    }

    @Override
    public Author saveAuthor(Author author) {
        profileLogger.logEvent();
        AuthorEntity entity = mapper.mapToEntity(author);
        entity = repository.save(entity);
        return mapper.mapToModel(entity);
    }


    @Override
    public Author loadAuthor(Long id) {
        profileLogger.logEvent();
        return mapper.mapToModel(repository.findById(id).orElse(null));
    }


    @Override
    public List<Author> loadAllAuthors() {
        profileLogger.logEvent();
        return mapToModel((List<AuthorEntity>) repository.findAll());
    }


    private List<Author> mapToModel(List<AuthorEntity> entities) {
        List<Author> authors = new ArrayList<>();

        for (AuthorEntity entity : entities) {
            authors.add(mapper.mapToModel(entity));
        }

        return authors;
    }
}

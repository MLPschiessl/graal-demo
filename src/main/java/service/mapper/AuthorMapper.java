package service.mapper;


import model.Author;
import org.mapstruct.Mapper;
import persistence.entity.AuthorEntity;

@Mapper(uses = DiaryEntryMapper.class)
public interface AuthorMapper {

    Author mapToModel(AuthorEntity value);

    AuthorEntity mapToEntity(Author value);
}

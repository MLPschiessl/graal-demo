package service.mapper;


import model.DiaryEntry;
import org.mapstruct.Mapper;
import persistence.entity.DiaryEntryEntity;

@Mapper
public interface DiaryEntryMapper {

    DiaryEntry mapToModel(DiaryEntryEntity value);

    DiaryEntryEntity mapToEntity(DiaryEntry value);

}

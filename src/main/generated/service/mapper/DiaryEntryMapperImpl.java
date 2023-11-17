package service.mapper;

import javax.annotation.processing.Generated;
import model.DiaryEntry;
import org.springframework.stereotype.Component;
import persistence.entity.DiaryEntryEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class DiaryEntryMapperImpl implements DiaryEntryMapper {

    @Override
    public DiaryEntry mapToModel(DiaryEntryEntity value) {
        if ( value == null ) {
            return null;
        }

        DiaryEntry diaryEntry = new DiaryEntry();

        diaryEntry.setId( value.getId() );
        diaryEntry.setDateToDescribe( value.getDateToDescribe() );
        diaryEntry.setContent( value.getContent() );

        return diaryEntry;
    }

    @Override
    public DiaryEntryEntity mapToEntity(DiaryEntry value) {
        if ( value == null ) {
            return null;
        }

        DiaryEntryEntity diaryEntryEntity = new DiaryEntryEntity();

        diaryEntryEntity.setId( value.getId() );
        diaryEntryEntity.setDateToDescribe( value.getDateToDescribe() );
        diaryEntryEntity.setContent( value.getContent() );

        return diaryEntryEntity;
    }
}

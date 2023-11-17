package service.mapper;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import model.Author;
import model.Diary;
import model.DiaryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import persistence.entity.AuthorEntity;
import persistence.entity.DiaryEntity;
import persistence.entity.DiaryEntryEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Autowired
    private DiaryEntryMapper diaryEntryMapper;

    @Override
    public Author mapToModel(AuthorEntity value) {
        if ( value == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( value.getId() );
        author.setName( value.getName() );
        author.setDiary( diaryEntityToDiary( value.getDiary() ) );

        return author;
    }

    @Override
    public AuthorEntity mapToEntity(Author value) {
        if ( value == null ) {
            return null;
        }

        AuthorEntity authorEntity = new AuthorEntity();

        authorEntity.setId( value.getId() );
        authorEntity.setName( value.getName() );
        authorEntity.setDiary( diaryToDiaryEntity( value.getDiary() ) );

        return authorEntity;
    }

    protected List<DiaryEntry> diaryEntryEntitySetToDiaryEntryList(Set<DiaryEntryEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<DiaryEntry> list = new ArrayList<DiaryEntry>( set.size() );
        for ( DiaryEntryEntity diaryEntryEntity : set ) {
            list.add( diaryEntryMapper.mapToModel( diaryEntryEntity ) );
        }

        return list;
    }

    protected Diary diaryEntityToDiary(DiaryEntity diaryEntity) {
        if ( diaryEntity == null ) {
            return null;
        }

        Diary diary = new Diary();

        diary.setId( diaryEntity.getId() );
        diary.setEntries( diaryEntryEntitySetToDiaryEntryList( diaryEntity.getEntries() ) );

        return diary;
    }

    protected Set<DiaryEntryEntity> diaryEntryListToDiaryEntryEntitySet(List<DiaryEntry> list) {
        if ( list == null ) {
            return null;
        }

        Set<DiaryEntryEntity> set = new LinkedHashSet<DiaryEntryEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( DiaryEntry diaryEntry : list ) {
            set.add( diaryEntryMapper.mapToEntity( diaryEntry ) );
        }

        return set;
    }

    protected DiaryEntity diaryToDiaryEntity(Diary diary) {
        if ( diary == null ) {
            return null;
        }

        DiaryEntity diaryEntity = new DiaryEntity();

        diaryEntity.setId( diary.getId() );
        diaryEntity.setEntries( diaryEntryListToDiaryEntryEntitySet( diary.getEntries() ) );

        return diaryEntity;
    }
}

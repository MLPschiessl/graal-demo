package persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import persistence.entity.DiaryEntryEntity;

@Repository
public interface DiaryEntryRepository extends CrudRepository<DiaryEntryEntity, Long> {

}

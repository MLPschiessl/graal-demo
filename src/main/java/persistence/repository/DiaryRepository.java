package persistence.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import persistence.entity.DiaryEntity;

@Repository
public interface DiaryRepository extends CrudRepository<DiaryEntity, Long> {

}

package persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "DIARY")
@SequenceGenerator(name = "diaryId", sequenceName = "DIARY_SEQUENCE", initialValue = 1, allocationSize = 1)
public class DiaryEntity {

    public DiaryEntity() {
        //Default constructor
    }

    public DiaryEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "diaryId")
    @Column(name = "ID")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "DIARY")
    private Set<DiaryEntryEntity> entries;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<DiaryEntryEntity> getEntries() {
        return entries;
    }

    public void setEntries(Set<DiaryEntryEntity> entries) {
        this.entries = entries;
    }
}

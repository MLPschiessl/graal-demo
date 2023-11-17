package persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DIARY_ENTRY")
@SequenceGenerator(name = "diaryEntryId", sequenceName = "DIARY_ENTRY_SEQUENCE", initialValue = 1, allocationSize = 1)
public class DiaryEntryEntity {

    @Id
    @GeneratedValue(generator = "diaryEntryId")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIBED_DATE")
    private LocalDate dateToDescribe;

    @Column(name = "CONTENT")
    private String content;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateToDescribe() {
        return dateToDescribe;
    }

    public void setDateToDescribe(LocalDate dateToDescribe) {
        this.dateToDescribe = dateToDescribe;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiaryEntryEntity that = (DiaryEntryEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

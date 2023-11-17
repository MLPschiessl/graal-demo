package persistence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AUTHOR")
@SequenceGenerator(name = "authorId", sequenceName = "AUTHOR_SEQUENCE", initialValue = 1, allocationSize = 1)
public class AuthorEntity {

    @Id
    @GeneratedValue(generator = "authorId")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "DIARY", referencedColumnName = "ID")
    private DiaryEntity diary;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiaryEntity getDiary() {
        return diary;
    }

    public void setDiary(DiaryEntity diary) {
        this.diary = diary;
    }
}

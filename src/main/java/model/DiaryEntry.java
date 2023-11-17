package model;

import java.time.LocalDate;

public class DiaryEntry {

    private Long id;

    private LocalDate dateToDescribe;

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
}

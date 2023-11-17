package model;

import java.util.List;

public class Diary {

    private Long id;

    private List<DiaryEntry> entries;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DiaryEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<DiaryEntry> entries) {
        this.entries = entries;
    }
}

package service.impl;


import java.util.List;
import model.DiaryEntry;

public interface DiaryEntryService {

    void saveEntry(Long parentId, DiaryEntry entry);

    DiaryEntry loadEntryExample();

    List<DiaryEntry> loadAllEntries();

    List<DiaryEntry> loadAllEntriesByDiary(Long id);

}

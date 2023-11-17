package web.controller;

import java.util.List;
import model.DiaryEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.impl.DiaryEntryService;

@RestController
public class DiaryEntryController {

    private final DiaryEntryService entryService;


    public DiaryEntryController(DiaryEntryService entryService) {
        this.entryService = entryService;
    }


    @GetMapping("/example-entry")
    public DiaryEntry loadEntryExample() {
        return entryService.loadEntryExample();
    }


    @GetMapping("/entries")
    public List<DiaryEntry> loadEntries() {
        return entryService.loadAllEntries();
    }


    //should be in own DiaryController by Mapping path. For demo showcase its located here.
    @GetMapping("/diary/{id}/entries")
    public List<DiaryEntry> loadEntriesByDiary(@PathVariable(name = "id") Long id) {
        return entryService.loadAllEntriesByDiary(id);
    }


    //should be in own DiaryController by Mapping path. For demo showcase its located here.
    @PostMapping("/diary/{id}/entry")
    public void saveEntry(@PathVariable(name = "id") Long id, @RequestBody DiaryEntry entry) {
        entryService.saveEntry(id, entry);
    }

}

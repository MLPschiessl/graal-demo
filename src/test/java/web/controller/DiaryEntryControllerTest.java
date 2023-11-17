package web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import model.DiaryEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import service.impl.DiaryEntryService;
import web.controller.DiaryEntryControllerTest.TestDiaryEntryService;

@WebMvcTest
@Import({
    DiaryEntryController.class,
    TestDiaryEntryService.class})
class DiaryEntryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testLoadEntryExample() throws Exception {
        mockMvc.perform(get("/example-entry"))
            .andExpectAll(
                status().isOk(),
                content().json("{\"id\":null,\"dateToDescribe\":null,\"content\":\"Der Vortrag hat Spaß gemacht!\"}")
            );
    }


    static class TestDiaryEntryService implements DiaryEntryService {

        @Override
        public void saveEntry(Long parentId, DiaryEntry entry) {

        }

        @Override
        public DiaryEntry loadEntryExample() {
            DiaryEntry entry = new DiaryEntry();
            entry.setContent("Der Vortrag hat Spaß gemacht!");
            return entry;
        }

        @Override
        public List<DiaryEntry> loadAllEntries() {
            return null;
        }

        @Override
        public List<DiaryEntry> loadAllEntriesByDiary(Long id) {
            return null;
        }
    }


}

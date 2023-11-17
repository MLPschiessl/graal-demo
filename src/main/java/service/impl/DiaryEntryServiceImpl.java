package service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.DiaryEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import persistence.entity.DiaryEntity;
import persistence.entity.DiaryEntryEntity;
import persistence.repository.DiaryEntryRepository;
import persistence.repository.DiaryRepository;
import service.mapper.DiaryEntryMapper;
import service.profile.ProfileLogger;

@Service
public class DiaryEntryServiceImpl implements DiaryEntryService {

    @Value("classpath:example-entry.json")
    private Resource exampleResource;

    private final DiaryRepository diaryRepository;

    private final DiaryEntryRepository entryRepository;

    private final DiaryEntryMapper mapper;

    private final ObjectMapper objectMapper;

    private final ProfileLogger profileLogger;

    private static final Logger LOG = LoggerFactory.getLogger(DiaryEntryServiceImpl.class);


    public DiaryEntryServiceImpl(DiaryRepository diaryRepository, DiaryEntryRepository entryRepository, DiaryEntryMapper mapper,
        ObjectMapper objectMapper, ProfileLogger profileLogger) {
        this.diaryRepository = diaryRepository;
        this.entryRepository = entryRepository;
        this.mapper = mapper;
        this.objectMapper = objectMapper;
        this.profileLogger = profileLogger;
    }


    @Override
    public void saveEntry(Long parentId, DiaryEntry entry) {
        profileLogger.logEvent();
        Optional<DiaryEntity> diaryOpt = diaryRepository.findById(parentId);

        if (diaryOpt.isEmpty()) {
            throw new IllegalArgumentException("Entry cannot be written in non-existing diary!");
        }

        DiaryEntity diary = diaryOpt.get();
        DiaryEntryEntity entryEntity = mapper.mapToEntity(entry);
        diary.getEntries().add(entryEntity);
        diaryRepository.save(diary);
    }


    @Override
    public DiaryEntry loadEntryExample() {
        try {
            String exampleJson = exampleResource.getContentAsString(StandardCharsets.UTF_8);
            return objectMapper.readValue(exampleJson, DiaryEntry.class);
        } catch (IOException e) {
            LOG.error("Unerwarteter Fehler beim Laden der Beispielressource.");
        }

        return null;
    }


    @Override
    public List<DiaryEntry> loadAllEntries() {
        profileLogger.logEvent();
        return mapToModel((List<DiaryEntryEntity>) entryRepository.findAll());
    }


    @Override
    public List<DiaryEntry> loadAllEntriesByDiary(Long id) {
        profileLogger.logEvent();
        Optional<DiaryEntity> diaryOpt = diaryRepository.findById(id);

        if (diaryOpt.isEmpty()) {
            throw new IllegalArgumentException("Entry cannot be written in non-existing diary!");
        }

        DiaryEntity diary = diaryOpt.get();
        return mapToModel(new ArrayList<>(diary.getEntries()));
    }


    private List<DiaryEntry> mapToModel(List<DiaryEntryEntity> entities) {
        List<DiaryEntry> entries = new ArrayList<>();

        for (DiaryEntryEntity entity : entities) {
            entries.add(mapper.mapToModel(entity));
        }

        return entries;
    }

}

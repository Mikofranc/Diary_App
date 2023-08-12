package org.example.service;

import org.example.data.model.Entry;
import org.example.dto.DiaryDt0.*;

public interface DiaryService {
    void unlockDiary(UnlockDiaryRequest request);
    boolean lockDiary();
    CreateEntryResponse createThisEntry(CreateEntryRequest request);

    void deleteEntry(int id);
    EntryFindById findEntryById(int id);
    UpdateEntryResponse updateEntry(UpdateEntryRequest request);
}

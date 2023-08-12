package org.example.service;

import org.example.dto.DiaryDt0.CreateEntryRequest;
import org.example.dto.DiaryDt0.CreateEntryResponse;

public interface EntryService {
    CreateEntryResponse createEntry(CreateEntryRequest request);

    long count();

}

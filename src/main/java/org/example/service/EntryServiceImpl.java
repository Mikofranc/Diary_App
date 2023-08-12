package org.example.service;

import org.example.data.model.Entry;
import org.example.data.repository.EntryRepo;
import org.example.dto.DiaryDt0.CreateEntryRequest;
import org.example.dto.DiaryDt0.CreateEntryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class EntryServiceImpl implements EntryService{
    @Autowired
    private EntryRepo entryRepo;
    @Override
    public CreateEntryResponse createEntry(CreateEntryRequest request) {
        Entry entry = new Entry();
        entry.setTitle(request.getTitle());
        entry.setBody(request.getBody());
        entry.setDateCreated(LocalDateTime.now());

        var newEntry = entryRepo.save(entry);


        CreateEntryResponse entryResponse = new CreateEntryResponse();
        entryResponse.setId(newEntry.getId());
        entryResponse.setBody(newEntry.getBody());
        entryResponse.setTitle(newEntry.getTitle());
        return entryResponse;
    }

    @Override
    public long count() {
        return entryRepo.count();
    }


}

package org.example.service;

import org.example.data.model.Entry;
import org.example.data.repository.EntryRepo;
import org.example.dto.DiaryDt0.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryServiceImpl implements  DiaryService{
    @Autowired
    private EntryRepo entryRepo;

    public DiaryServiceImpl() {
    }

    @Override
    public CreateEntryResponse createThisEntry(CreateEntryRequest request) {
        Entry entry = new Entry();
        entry.setDateCreated(LocalDateTime.now());
        entry.setBody(request.getBody());
        entry.setTitle(request.getTitle());
        entryRepo.save(entry);
        CreateEntryResponse response = new CreateEntryResponse();
        response.setBody(entry.getBody());
        response.setTitle(entry.getTitle());
        response.setId(entry.getId());
        return response;
    }

    @Override
    public void unlockDiary(UnlockDiaryRequest request) {

    }

    @Override
    public boolean lockDiary() {
        return false;
    }

    @Override
    public void deleteEntry(int id) {
        String idNumber = entryRepo.findAll().get(id).getId();
        entryRepo.deleteById(idNumber);
    }
    @Override
    public EntryFindById findEntryById(int id) {
        EntryFindById reponse = new EntryFindById();
        reponse.setDateCreated(entryRepo.findAll().get(id).getDateCreated());
        reponse.setBody(entryRepo.findAll().get(id).getBody());
        reponse.setTitle(entryRepo.findAll().get(id).getTitle());
        reponse.setId(entryRepo.findAll().get(id).getId());
        return reponse;
    }
    @Override
    public UpdateEntryResponse updateEntry(UpdateEntryRequest request) {
        String newId = entryRepo.findAll().get(request.getId()).getId();
        Entry entry = new Entry();
        entry.setDateCreated(LocalDateTime.now());
        entry.setTitle(request.getTitle());
        entry.setId(newId);
        entry.setBody(request.getBody());
        var updatedEntry =entryRepo.save(entry);
        UpdateEntryResponse response = new UpdateEntryResponse();
        response.setId(updatedEntry.getId());
        response.setBody(updatedEntry.getBody());
        response.setTitle(updatedEntry.getTitle());
        return response;
    }


}

package org.example.data.repository;

import org.example.data.model.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntryRepo extends MongoRepository<Entry, String> {
}

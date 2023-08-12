package org.example.data.repository;

import org.example.data.model.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiaryRepo extends MongoRepository<Diary, String> {
}

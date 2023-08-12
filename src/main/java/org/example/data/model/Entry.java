package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document("Entry")
public class Entry {
    @Id
    private String id;
    private String body;
    private String title;
    @CreatedDate
    private LocalDateTime dateCreated;
}

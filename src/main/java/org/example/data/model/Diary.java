package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Document("Diary")
public class Diary {
    @Id
    private  String id;
    private  boolean isLocked = true;
    private  User user;
    private List<Entry> entries;

    public void setUser(Optional<User> user) {

    }
}

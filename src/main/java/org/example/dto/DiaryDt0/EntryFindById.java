package org.example.dto.DiaryDt0;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
public class EntryFindById {
    @Id
    private String id;
    private String body;
    private String title;
    @CreatedDate
    private LocalDateTime dateCreated;
}

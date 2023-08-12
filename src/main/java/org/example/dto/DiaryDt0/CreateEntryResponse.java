package org.example.dto.DiaryDt0;

import lombok.Data;

@Data
public class CreateEntryResponse {
    private String id;
    private  String body;
    private String title;
}

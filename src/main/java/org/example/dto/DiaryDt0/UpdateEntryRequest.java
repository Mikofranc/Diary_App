package org.example.dto.DiaryDt0;

import lombok.Data;

@Data
public class UpdateEntryRequest {
    private String title;
    private String body;
    private int id;
}

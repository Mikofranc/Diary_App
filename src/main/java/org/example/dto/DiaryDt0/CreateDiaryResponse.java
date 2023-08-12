package org.example.dto.DiaryDt0;

import lombok.Data;
import org.example.data.model.Entry;
import org.example.data.model.User;

import java.util.ArrayList;
import java.util.List;
@Data
public class CreateDiaryResponse {
    private  String id;
    private  boolean isLocked = true;
    private List<Entry> entries = new ArrayList<>();
}

package org.example.dto;

import lombok.Data;
import org.example.data.model.User;

import java.util.Optional;

@Data
public class LoginResponse {
    private Optional<User> user;
//    private String id;
//    private String firstName;
//    private String lastName;
//    private String username;
//    @CreatedDate
//    private LocalDateTime date;
//    private Role role;
//    private List<Diary> diary = new ArrayList<>();
}

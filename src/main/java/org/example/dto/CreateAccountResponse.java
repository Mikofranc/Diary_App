package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.data.model.Role;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountResponse {
    private String firstName;
    private String lastName;
    private String username;
    private String date;
    private Role role;
}

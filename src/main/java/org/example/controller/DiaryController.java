package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.CreateAccountRequest;
import org.example.dto.CreateAccountResponse;
import org.example.dto.LoginRequest;
import org.example.dto.LoginResponse;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/diary")
public class DiaryController {
    private UserService userService;
    @PostMapping("/createAccount")
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody CreateAccountRequest createAccountRequest){
          userService.createAccount(createAccountRequest);
          return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public  ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        userService.login(request);
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
    public void createDiary(){

    }
    public void addEntry(){

    }
    public void deleteEntry(){

    }
    public void updateEntry(){

    }
    public void findEntryById(){

    }
}

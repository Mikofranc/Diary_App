package org.example.service;

import org.example.data.model.Diary;
import org.example.data.model.Entry;
import org.example.data.model.User;

import org.example.data.repository.DiaryRepo;
import org.example.data.repository.EntryRepo;
import org.example.data.repository.UserRepository;
import org.example.dto.CreateAccountRequest;
import org.example.dto.CreateAccountResponse;
import org.example.dto.DiaryDt0.CreateDiaryRequest;
import org.example.dto.DiaryDt0.CreateDiaryResponse;
import org.example.dto.DiaryDt0.CreateEntryRequest;
import org.example.dto.DiaryDt0.CreateEntryResponse;
import org.example.dto.LoginRequest;
import org.example.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private DiaryRepo diaryRepo;
    @Autowired
    private EntryRepo entryRepo;
    @Autowired
    private DiaryService diaryService;
    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        User user = new User();
        user.setDate(LocalDateTime.now());
        user.setPassword(request.getPassword());
//        user.setRole(request.getRole());
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());


        var savedUser = userRepository.save(user);

        CreateAccountResponse response = new CreateAccountResponse();
        response.setDate(String.valueOf(savedUser.getDate()));
        response.setUsername(savedUser.getUsername());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
//        response.setRole(savedUser.getRole());
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response = new LoginResponse();
            if(userRepository.checkIfUserIsRegistered(request.getUserName(), request.getPassword()).isPresent()) {
               var user = userRepository.checkIfUserIsRegistered(request.getUserName(), request.getPassword());
                response.setUser(user);
               return response;
            }
        return response;
    }

    @Override
    public CreateDiaryResponse createDiary(CreateDiaryRequest diaryRequest) {
        if(userRepository.checkIfUserIsRegistered(diaryRequest.getUsername(), diaryRequest.getPassword()).isPresent()) {
            var user = userRepository.checkIfUserIsRegistered(diaryRequest.getUsername(), diaryRequest.getPassword());
            User castedUser = new User(user);
            Diary diary = new Diary();
            diary.setLocked(false);
            diary.setUser(Optional.of(castedUser));
            var createdDiary = diaryRepo.save(diary);
            CreateDiaryResponse response = new CreateDiaryResponse();
            response.setId(createdDiary.getId());
            response.setEntries(createdDiary.getEntries());
            response.setLocked(false);
            return  response;
        }
        return null;
    }
    @Override
    public CreateEntryResponse createEntry(CreateEntryRequest request){
       return  diaryService.createThisEntry(request);
    }




}

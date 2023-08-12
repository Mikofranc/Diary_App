package org.example.service;

import org.example.data.model.Entry;
import org.example.data.model.User;
import org.example.dto.CreateAccountRequest;
import org.example.dto.CreateAccountResponse;
import org.example.dto.DiaryDt0.CreateDiaryRequest;
import org.example.dto.DiaryDt0.CreateDiaryResponse;
import org.example.dto.DiaryDt0.CreateEntryRequest;
import org.example.dto.DiaryDt0.CreateEntryResponse;
import org.example.dto.LoginRequest;
import org.example.dto.LoginResponse;

public interface UserService {
    CreateAccountResponse createAccount(CreateAccountRequest request);
    LoginResponse login(LoginRequest request);
    CreateDiaryResponse createDiary(CreateDiaryRequest diaryRequest);
    CreateEntryResponse createEntry(CreateEntryRequest request);


}

package org.example.service;

import org.example.data.model.Role;

import org.example.data.repository.DiaryRepo;
import org.example.data.repository.EntryRepo;
import org.example.data.repository.UserRepository;
import org.example.dto.CreateAccountRequest;
import org.example.dto.DiaryDt0.CreateDiaryRequest;
import org.example.dto.DiaryDt0.CreateEntryRequest;
import org.example.dto.DiaryDt0.UpdateEntryRequest;
import org.example.dto.LoginRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import  static org.hamcrest.CoreMatchers.is;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {

}
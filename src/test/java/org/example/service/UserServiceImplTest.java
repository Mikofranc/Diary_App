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
    @Autowired
    private UserService userService;
    @Autowired
    private DiaryService diaryService;
    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private DiaryRepo diaryRepo;

    @Autowired
    private EntryRepo entryRepo;

    @Autowired
    private EntryServiceImpl entryService;
    @BeforeEach
    public void clearDataBase(){
        userRepository.deleteAll();
        diaryRepo.deleteAll();
        entryRepo.deleteAll();
    }

    @Test
    public void testToCreateAccount(){
        CreateAccountRequest request = new CreateAccountRequest();
        request.setRole(Role.BUYER);
        request.setUsername("mik");
        request.setPassword("1234");
        request.setFirstName("micheal");
        request.setLastName("Ayomide");
        userService.createAccount(request);
        assertEquals(1, userRepository.count());

    }
    @Test
    public void testToCreateAccount_MultipleAcc(){
        CreateAccountRequest request = new CreateAccountRequest();
        request.setRole(Role.BUYER);
        request.setUsername("mik");
        request.setPassword("1234");
        request.setFirstName("micheal");
        request.setLastName("Ayomide");
        userService.createAccount(request);


        CreateAccountRequest request1 = new CreateAccountRequest();
        request.setRole(Role.BUYER);
        request1.setUsername("john");
        request1.setPassword("password");
        request1.setFirstName("micheal");
        request1.setLastName("paulo");
        userService.createAccount(request1);
        assertEquals(2, userRepository.count());
        System.out.println(userRepository.findAll());
    }
  @Test
    public void loginTest(){
      CreateAccountRequest request1 = new CreateAccountRequest();
      request1.setRole(Role.BUYER);
      request1.setUsername("john");
      request1.setPassword("password");
      request1.setFirstName("micheal");
      request1.setLastName("paulo");
      userService.createAccount(request1);

      LoginRequest request = new LoginRequest();
      request.setPassword("password");
      request.setUserName("john");
        var check = userService.login(request);
        assertThat(userRepository.findAll().get(0).getFirstName(),is("micheal"));
      System.out.println(check);
  }
  @Test
    public  void testToCreateDiary(){
      CreateAccountRequest request1 = new CreateAccountRequest();
      request1.setRole(Role.BUYER);
      request1.setUsername("john");
      request1.setPassword("password");
      request1.setFirstName("micheal");
      request1.setLastName("paulo");
      userService.createAccount(request1);
      CreateDiaryRequest request = new CreateDiaryRequest();
      request.setPassword("password");
      request.setUsername("john");
        var  z =userService.createDiary(request);
      assertThat(diaryRepo.count(),is(1L));
  }
    @Test
    public  void testToCreateMultiple_Diary(){
        CreateAccountRequest request1 = new CreateAccountRequest();
        request1.setRole(Role.BUYER);
        request1.setUsername("john");
        request1.setPassword("password");
        request1.setFirstName("micheal");
        request1.setLastName("paulo");
        userService.createAccount(request1);

        CreateDiaryRequest request = new CreateDiaryRequest();
        request.setPassword("password");
        request.setUsername("john");
        userService.createDiary(request);
        CreateDiaryRequest request2 = new CreateDiaryRequest();
        request.setPassword("password");
        request.setUsername("john");
        userService.createDiary(request);
        CreateDiaryRequest request3 = new CreateDiaryRequest();
        request.setPassword("password");
        request.setUsername("john");
        var z =userService.createDiary(request);
        assertThat(diaryRepo.count(),is(3L));
        System.out.println(z);
    }
    @Test
    public void testToCreateEntry(){
        CreateEntryRequest request = new CreateEntryRequest();
        request.setBody("mmmmm");
        request.setTitle("mike");
        entryService.createEntry(request);
        assertThat(entryService.count(),is(1L));
    }
    @Test
    public void testToCreateEntry_truDiary(){
        CreateEntryRequest request = new CreateEntryRequest();
        request.setBody("mmmmm");
        request.setTitle("mike");
        diaryService.createThisEntry(request);
        assertThat(entryService.count(),is(1L));
    }
    @Test
    public void testToCreateMultiEntry_truDiary(){
        CreateEntryRequest request = new CreateEntryRequest();
        request.setBody("mmmmm");
        request.setTitle("mike");
        diaryService.createThisEntry(request);

        CreateEntryRequest request1 = new CreateEntryRequest();
        request1.setBody("mmmmm");
        request1.setTitle("mike");
        diaryService.createThisEntry(request1);

        CreateEntryRequest request2 = new CreateEntryRequest();
        request2.setBody("mmmmm");
        request2.setTitle("mike");
        diaryService.createThisEntry(request2);
        assertThat(entryService.count(),is(3L));
    }
    @Test
    public void testToUpdateEntry(){
        CreateEntryRequest request = new CreateEntryRequest();
        request.setBody("micheal");
        request.setTitle("mike");
        var x =diaryService.createThisEntry(request);

        CreateEntryRequest request1 = new CreateEntryRequest();
        request1.setBody("paulo");
        request1.setTitle("paul");
        var y =diaryService.createThisEntry(request1);


        CreateEntryRequest request2 = new CreateEntryRequest();
        request2.setBody("afolashade");
        request2.setTitle("shade");
        var z = diaryService.createThisEntry(request2);

        UpdateEntryRequest updateEntryRequest = new UpdateEntryRequest();
        updateEntryRequest.setId(1);
        updateEntryRequest.setBody("aaaaaaa");
        updateEntryRequest.setTitle("qq");

        diaryService.updateEntry(updateEntryRequest);

        System.out.println(x);
        assertThat(entryRepo.findAll().get(1).getTitle(),is("qq"));
    }
    @Test
    public void testToDeleteEntry(){
        CreateEntryRequest request = new CreateEntryRequest();
        request.setBody("micheal");
        request.setTitle("mike");
        var x =diaryService.createThisEntry(request);
        CreateEntryRequest request1 = new CreateEntryRequest();
        request1.setBody("paulo");
        request1.setTitle("paul");
        var y =diaryService.createThisEntry(request1);
        CreateEntryRequest request2 = new CreateEntryRequest();
        request2.setBody("afolashade");
        request2.setTitle("shade");
        var z = diaryService.createThisEntry(request2);
        diaryService.deleteEntry(2);
        diaryService.deleteEntry(0);

        System.out.println(x);
        assertThat(entryService.count(),is(1L));
    }

}
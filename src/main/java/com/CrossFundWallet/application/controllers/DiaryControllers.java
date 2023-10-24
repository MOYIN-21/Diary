package com.CrossFundWallet.application.controllers;
import com.CrossFundWallet.application.data.models.Diary;
import com.CrossFundWallet.application.dtos.LogInRequest;
import com.CrossFundWallet.application.dtos.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.CrossFundWallet.application.services.DiaryServices;
import com.CrossFundWallet.application.services.DiaryServicesImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
public class DiaryControllers {
    Diary diary = new Diary();
    @Autowired
    DiaryServices diaryServices = new DiaryServicesImpl();

    @PostMapping("/register")
    public String register(RegisterUserRequest registerUserRequest) {
        try {
            diaryServices.register(registerUserRequest);
            return "Successful";
        }
        catch (Exception error){
            return error.getMessage();
        }
    }

    @PostMapping("/lock")
    public String lock(@RequestBody String username) {
        diaryServices.lock(username);
        return "Locked";
    }

    @PostMapping("/createEntry")
    public String createEntry(@RequestBody String username, String title, String body) {
        try {
            diaryServices.addEntry(username, title, body);
            return "Entry Created Successfully";
        }
        catch (Exception error){
            return error.getMessage();
        }
    }
    @PostMapping("/unlock")
    public String unlock(@RequestBody LogInRequest logInRequest) {
        try {
            diaryServices.unlock(logInRequest);
            return "Diary Unlocked";
        }
        catch (Exception error){
            return error.getMessage();
        }
    }
    @PostMapping("/findByTitle/{userName}/{title}")
    public String findEntryBy(@PathVariable String userName, @PathVariable String title) {
        try {
//            Entry entry = diaryServices.findEntry(username, title);
            return "Entry search was successfully" + " " + diaryServices.findEntry(userName, title);
        }
        catch (Exception error){
            return error.getMessage();
        }
    }
}

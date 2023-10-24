package com.CrossFundWallet.application.services;

import com.CrossFundWallet.application.data.models.Diary;
import com.CrossFundWallet.application.data.models.Entry;
import com.CrossFundWallet.application.dtos.LogInRequest;
import com.CrossFundWallet.application.dtos.RegisterUserRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DiaryServices {
    void register(RegisterUserRequest registerUserRequest);

    long count();

    Diary findByUsername(String username);

    void delete(String username, String password);

    void update(String username, String oldPassword, String newPassword);

    Entry addEntry(String username, String title, String body);

    Optional<Entry> findEntry(String username, String title);

    void lock(String username);

    void unlock(LogInRequest logInRequest);
}


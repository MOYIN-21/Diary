package com.CrossFundWallet.application.utils;

import com.CrossFundWallet.application.data.models.Diary;
import com.CrossFundWallet.application.dtos.RegisterUserRequest;


public class map {
    public static void map(RegisterUserRequest registerUserRequest, Diary diary){
        diary.setUsername(registerUserRequest.getUserName());
        diary.setPassword(registerUserRequest.getPassword());
    }
}

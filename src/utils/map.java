package utils;

import data.models.Diary;
import dtos.RegisterUserRequest;

public class map {
    public static void map(RegisterUserRequest registerUserRequest, Diary diary){
        diary.setUsername(registerUserRequest.getUserName());
        diary.setPassword(registerUserRequest.getPassword());

    }
}

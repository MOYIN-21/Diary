package com.CrossFundWallet.application.dtos;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String userName;
    private String password;
}

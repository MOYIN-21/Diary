package com.CrossFundWallet.application.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data

public class Diary {
        private int id;
        private String username;
        private String password;
        private List <Entry> entries = new ArrayList<>();
        private boolean isLocked;}
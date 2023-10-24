package com.CrossFundWallet.application.services;

import com.CrossFundWallet.application.data.models.Diary;
import com.CrossFundWallet.application.data.models.Entry;
import com.CrossFundWallet.application.data.repositories.DiaryRepository;
import com.CrossFundWallet.application.dtos.LogInRequest;
import com.CrossFundWallet.application.dtos.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.CrossFundWallet.application.utils.map.map;

@Service
public class DiaryServicesImpl implements DiaryServices {
    @Autowired
    private DiaryRepository diaryRepository;
    private EntryServicesImpl entryServices = new EntryServicesImpl();


    @Override
    public void register(RegisterUserRequest registerUserRequest) {
        validateUser(registerUserRequest.getUserName());
        Diary newDiary = new Diary();
        map(registerUserRequest, newDiary);
        diaryRepository.save(newDiary);
    }

    @Override
    public long count() {
        return diaryRepository.count();
    }


    @Override
    public void delete(String username, String password) {
        Diary diary = findByUsername(username);
        if(diary.getPassword().equals(password)) diaryRepository.delete(diary);
        else throw new IllegalArgumentException("Invalid details");
    }

    @Override
    public void update(String username, String oldPassword, String newPassword) {
        Diary diary = findByUsername(username);
        if(diary.getPassword().equals(oldPassword)) diary.setPassword(newPassword);
        else throw new IllegalArgumentException("Invalid details");
    }

    @Override
    public Diary findByUsername(String username) {
        for(Diary diary: diaryRepository.findAll())
            if(diary.getUsername().equals(username))
                return diary;
        throw new IllegalArgumentException("Diary does not exit");
    }

    @Override
    public Entry addEntry(String username, String title, String body) {
        validate(username);
        Entry entry = entryServices.addEntry(username, title, body);
        return entry;
    }



    @Override
    public Optional<Entry> findEntry(String username, String title) {
        Optional<Entry> entry = entryServices.findEntry(username, title);
        return entry;
    }

    @Override
    public void unlock(LogInRequest logInRequest){
        Optional<Diary> diary = diaryRepository.findByUsername(logInRequest.getUserName());
        if(diary.isEmpty()) throw new IllegalArgumentException("Diary Not Found");
        if(diary.get().getPassword().equals(logInRequest.getPassword())) diary.get().setLocked(false);
        else throw new IllegalArgumentException("Incorrect Password");
        diaryRepository.save(diary.get());
    }

    @Override
    public void lock(String username) {
        Diary foundDiary = findByUsername(username);
        foundDiary.setLocked(true);
        diaryRepository.save(foundDiary);
    }


    private void validateUser(String username) {
        for(Diary diary: diaryRepository.findAll())
            if (diary.getUsername().equals(username))
                throw new IllegalArgumentException("Username Already Exist");
    }


    private void validate(String username) {
        Optional<Diary> foundDiary = diaryRepository.findByUsername(username);
        if(foundDiary.isEmpty())
            throw new IllegalArgumentException("Diary not Found");
        if (foundDiary.isPresent()) {
            Diary found_Diary = foundDiary.get();
            if (found_Diary.isLocked()){
            }
        }
        throw new IllegalArgumentException("Diary is Locked");
    }

}

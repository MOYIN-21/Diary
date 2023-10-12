package services;

import data.models.Diary;
import data.models.Entry;
import data.repositories.DiaryRepository;
import data.repositories.DiaryRepositoryImpl;
import dtos.LogInRequest;
import dtos.RegisterUserRequest;

import static utils.map.map;

public class DiaryServicesImpl implements DiaryServices {
    private DiaryRepository diaryRepository = new DiaryRepositoryImpl();
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
    public Entry findEntry(String username, String title) {
        Entry entry = entryServices.findEntry(username, title);
        return entry;
    }

    @Override
    public void unlock(LogInRequest logInRequest){
        Diary diary = diaryRepository.findByUsername(logInRequest.getUserName());
        if(diary == null) throw new IllegalArgumentException("Diary Not Found");
        if(diary.getPassword().equals(logInRequest.getPassword())) diary.setLocked(false);
        else throw new IllegalArgumentException("Incorrect Password");
        diaryRepository.save(diary);
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
        Diary foundDiary = diaryRepository.findByUsername(username);
        if(foundDiary == null)
            throw new IllegalArgumentException("Diary not Found");
        if(foundDiary.isLocked())
            throw new IllegalArgumentException("Diary is Locked");
    }

}

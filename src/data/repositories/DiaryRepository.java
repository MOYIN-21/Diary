package data.repositories;

import data.models.Diary;

public interface DiaryRepository {
    Diary save(Diary diary);

    void delete(Diary diary);

    long count();

    Diary findById(int i);

    Iterable<Diary> findAll();

    void clear();

    Diary findByUsername(String username);
}
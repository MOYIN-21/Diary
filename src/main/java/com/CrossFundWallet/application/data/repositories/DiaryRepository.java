package com.CrossFundWallet.application.data.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.CrossFundWallet.application.data.models.Diary;
import java.util.Optional;

@Repository

public interface DiaryRepository extends MongoRepository<Diary, String> {
    Optional<Diary> findByUsername(String username);
}

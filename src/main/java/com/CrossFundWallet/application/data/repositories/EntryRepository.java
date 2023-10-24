package com.CrossFundWallet.application.data.repositories;

import com.CrossFundWallet.application.data.models.Entry;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Repository

public interface EntryRepository extends MongoRepository<Entry, String> {
    Optional<Entry> findByOwnerNameAndTitle(String ownerName, String title);
}

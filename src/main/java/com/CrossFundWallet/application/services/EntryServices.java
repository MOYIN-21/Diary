package com.CrossFundWallet.application.services;

import com.CrossFundWallet.application.data.models.Entry;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public interface EntryServices {
    Entry addEntry(String ownerName, String title, String body);

    long count();

    void delete(String ownerName, String title);

    Optional<Entry> findEntry(String ownerName, String title);

}

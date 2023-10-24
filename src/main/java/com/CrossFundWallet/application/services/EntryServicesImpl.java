package com.CrossFundWallet.application.services;

import com.CrossFundWallet.application.data.models.Entry;
import com.CrossFundWallet.application.data.repositories.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class EntryServicesImpl implements EntryServices{
    private EntryRepository entryRepository;
    @Override
    public Entry addEntry(String ownerName, String title, String body) {
        verifyTitle(ownerName, title);
        Entry newEntry = new Entry();
        newEntry.setOwnerName(ownerName);
        newEntry.setTitle(title);
        newEntry.setBody(body);
        entryRepository.save(newEntry);
        return newEntry;
    }

    private void verifyTitle(String username, String title) {
        Optional<Entry> foundEntry = entryRepository.findByOwnerNameAndTitle(username, title);
        if(foundEntry.isPresent())
            throw new IllegalArgumentException("Entry Title Already Exists");
    }

    @Override
    public Optional<Entry> findEntry(String ownerName, String title) {
        Optional<Entry> foundEntry = entryRepository.findByOwnerNameAndTitle(ownerName, title);
        boolean entryIsNotFound = foundEntry.isEmpty();
        if(entryIsNotFound) throw new IllegalArgumentException("Entry is not Found");
        return foundEntry;
    }

    @Override
    public long count(){
        return entryRepository.count();
    }

    @Override
    public void delete(String ownerName, String title) {
        Entry foundEntry = entryRepository.findByOwnerNameAndTitle(ownerName, title).get();
        entryRepository.delete(foundEntry);
    }
}

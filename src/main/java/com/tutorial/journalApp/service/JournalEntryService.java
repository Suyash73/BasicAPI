package com.tutorial.journalApp.service;


import com.tutorial.journalApp.controller.entity.JournalEntry;
import com.tutorial.journalApp.controller.entity.User;
import com.tutorial.journalApp.repository.JournalEntryRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class JournalEntryService {
    // create entry in database
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry journalEntry, String userName) {
        User user= userService.getUserEntryByusername(userName);
        user.getJournalEntries().add(journalEntry);
        journalEntry.setDate(LocalDateTime.now());
        journalEntryRepository.save(journalEntry);
        userService.saveUserEntry(user);
    }
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);

    }

    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepository.findAll();
    }

    public JournalEntry getJournalEntryById(ObjectId id) {
        return journalEntryRepository.findById(id).orElse(null);
    }

    public void deleteJournalEntryById(ObjectId id, String userName) {
        User user= userService.getUserEntryByusername(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        journalEntryRepository.deleteById(id);
        userService.saveUserEntry(user);
    }
}

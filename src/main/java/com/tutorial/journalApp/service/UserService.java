package com.tutorial.journalApp.service;

import com.tutorial.journalApp.controller.entity.JournalEntry;
import com.tutorial.journalApp.controller.entity.User;
import com.tutorial.journalApp.repository.JournalEntryRepository;
import com.tutorial.journalApp.repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserEntryRepository userEntryRepository;

    public void saveUserEntry(User user) {
        userEntryRepository.save(user);
    }

    public List<User> getAllUserEntries() {
        return userEntryRepository.findAll();
    }

    public User getUserEntryByusername(String username) {
        return userEntryRepository.findByUsername(username);
    }

    public void deleteUserEntryById(ObjectId id) {
        userEntryRepository.deleteById(id);
    }
}

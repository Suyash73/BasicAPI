package com.tutorial.journalApp.controller;

import com.tutorial.journalApp.controller.entity.JournalEntry;
import com.tutorial.journalApp.controller.entity.User;
import com.tutorial.journalApp.service.JournalEntryService;
import com.tutorial.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journalV2")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;


    //private Map<String, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("abc/{userName}")
    public ResponseEntity<?> getAll(@PathVariable String userName) {
        User user =  userService.getUserEntryByusername(userName);
        List<JournalEntry> ofUser = user.getJournalEntries();
        //List<JournalEntry> result = journalEntryService.getAllJournalEntries();
        //return new ArrayList<>(journalEntries.values());
        if (ofUser.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(ofUser, HttpStatus.OK);
        }
    }

    @PostMapping("def/{userName}")
    public ResponseEntity<JournalEntry> setJournalEntries(@RequestBody JournalEntry journalEntry, @PathVariable String userName) {
        //journalEntries.put(journalEntry.getId(), journalEntry);
        try {
            journalEntry.setDate(LocalDateTime.now());
            User user =  userService.getUserEntryByusername(userName);
            user.
            //journalEntryService.saveEntry(journalEntry);
            return new ResponseEntity<>(journalEntry, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("id/{getId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId getId) {

        //return journalEntries.get(getId);
        Optional<JournalEntry> journalEntry = Optional.ofNullable(journalEntryService.getJournalEntryById(getId));
        //return journalEntryService.getJournalEntryById(getId);
        if (journalEntry.isPresent()) {
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("DeleteId/{myId}")
    public ResponseEntity<JournalEntry> deleteJournalEntryById(@PathVariable ObjectId myId) {

        //return journalEntries.remove(myId);
        Optional<JournalEntry> findJournalEntry = Optional.ofNullable(journalEntryService.getJournalEntryById(myId));
        if (findJournalEntry.isPresent()) {
            journalEntryService.deleteJournalEntryById(myId);
            return new ResponseEntity<>(findJournalEntry.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("update/{myid}")
    public ResponseEntity<?> updateJournalEntry(@PathVariable ObjectId myid, @RequestBody JournalEntry journalEntry) {
        //return journalEntries.put(myid, journalEntry);
        //return journalEntries.get(id);
        //return null;
        //journalEntry.setDate(LocalDateTime.now());
        JournalEntry oldJournalEntry = journalEntryService.getJournalEntryById(myid);
        if (oldJournalEntry != null) {
            oldJournalEntry.setTitle(journalEntry.getTitle() == null || journalEntry.getTitle().equals("") ? oldJournalEntry.getTitle() : journalEntry.getTitle());
            oldJournalEntry.setContent(journalEntry.getContent() == null || journalEntry.getContent().equals("") ? oldJournalEntry.getContent() : journalEntry.getContent());
            //return journalEntry;
            journalEntryService.saveEntry(oldJournalEntry);
            return new ResponseEntity<>(oldJournalEntry, HttpStatus.OK);

        }


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}

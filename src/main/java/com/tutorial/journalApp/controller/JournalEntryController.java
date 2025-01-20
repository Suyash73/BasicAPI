package com.tutorial.journalApp.controller;

import com.tutorial.journalApp.controller.entity.JournalEntry;
import org.springframework.context.expression.MapAccessor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/abc")
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("def")
    public boolean setJournalEntries(@RequestBody JournalEntry journalEntry) {
        journalEntries.put(journalEntry.getId(), journalEntry);
        return true;
    }

    @GetMapping("id/{getId}")
    public JournalEntry getJournalEntryById(@PathVariable Long getId) {
        return journalEntries.get(getId);
    }

    @DeleteMapping("DeleteId/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
        return journalEntries.remove(myId);
    }

    @PutMapping("update/{myid}")
    public JournalEntry updateJournalEntry(@PathVariable Long myid, @RequestBody JournalEntry journalEntry) {
        return journalEntries.put(myid, journalEntry);
        //return journalEntries.get(id);
    }


}
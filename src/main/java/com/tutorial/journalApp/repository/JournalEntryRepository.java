package com.tutorial.journalApp.repository;

import com.tutorial.journalApp.controller.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
    // run query in database


}

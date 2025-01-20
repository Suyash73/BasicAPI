package com.tutorial.journalApp.repository;

import com.tutorial.journalApp.controller.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public interface UserEntryRepository extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
}

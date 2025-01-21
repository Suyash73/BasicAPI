package com.tutorial.journalApp.controller.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "journalEntry")
//@Controller
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;
    //private String id;
    @NonNull
    private String title;
    private String content;

    private LocalDateTime date;



}

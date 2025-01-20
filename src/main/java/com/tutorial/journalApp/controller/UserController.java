package com.tutorial.journalApp.controller;

import com.tutorial.journalApp.controller.entity.User;
import com.tutorial.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("alluser")
    public ResponseEntity<?> getAllUser(){
        List<User> allusers = userService.getAllUserEntries();
        if(allusers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(allusers, HttpStatus.OK);
    }

    @PostMapping("addUser")
    public ResponseEntity<?> addUser(@RequestBody User user){
        try {
            userService.saveUserEntry(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("updateUser/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName){
        User userinDb = userService.getUserEntryByusername(userName);
        //user.setPassword(user.getPassword());
        if(userinDb != null){
            userinDb.setUsername(user.getUsername());
            userinDb.setPassword(user.getPassword());
            userService.saveUserEntry(userinDb);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }





}

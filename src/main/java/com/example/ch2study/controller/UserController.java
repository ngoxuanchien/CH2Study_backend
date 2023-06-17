package com.example.ch2study.controller;

import com.example.ch2study.model.CH2StudyUser;
import com.example.ch2study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    private ConcurrentHashMap<String, CH2StudyUser> users;

    @Autowired
    private UserService userService;

    public UserController() {
        users = new ConcurrentHashMap<>();
    }

    @GetMapping
    public String getHello() {
        return "Hello";
    }

    @GetMapping(value = "/{id}")
    public CH2StudyUser getUser(@PathVariable("id") String id) {
        return users.get(id);
    }

    @PostMapping
    public CH2StudyUser addUser(@RequestParam String username,
                                @RequestParam String password) {
        return userService.createNewUser(username, password);
    }

    @PutMapping(value="/{id}")
    public CH2StudyUser updateUser(
            @PathVariable("id") String id,
            @RequestBody CH2StudyUser userUpdate
    ) {
        return userUpdate;
    }

    @DeleteMapping(value="/{id}")
    public CH2StudyUser deleteUser(
            @PathVariable("id") String id
    ) {
        CH2StudyUser userDelete = users.remove(id);
        return userDelete;
    }


}

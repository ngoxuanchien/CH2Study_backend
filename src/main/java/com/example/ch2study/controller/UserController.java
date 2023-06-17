package com.example.ch2study.controller;

import com.example.ch2study.model.CH2StudyUser;
import com.example.ch2study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/users")
public class UserController {

    private ConcurrentHashMap<String, CH2StudyUser> users;

    @Autowired
    private UserService userService;

    public UserController() {
        users = new ConcurrentHashMap<>();
    }

    @GetMapping
    public ResponseEntity<List<CH2StudyUser>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
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
    public CH2StudyUser updateUser(@PathVariable("id") String id,
                                   @RequestBody CH2StudyUser userUpdate
    ) {
        return userUpdate;
    }

    @DeleteMapping(value="/{id}")
    public CH2StudyUser deleteUser(@PathVariable("id") String id) {
        CH2StudyUser userDelete = users.remove(id);
        return userDelete;
    }


}

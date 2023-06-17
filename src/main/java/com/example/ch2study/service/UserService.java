package com.example.ch2study.service;

import com.example.ch2study.model.CH2StudyUser;
import com.example.ch2study.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public CH2StudyUser createNewUser(String userName, String password) {
        CH2StudyUser ch2StudyUser = CH2StudyUser.builder()
                .firstName(userName)
                .lastName(userName)
                .password(password)
                .email(userName + "@gmail.com")
                .build();

        userRepo.save(ch2StudyUser);
        return ch2StudyUser;
    }

}

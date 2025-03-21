package com.secureapp.service;

import com.secureapp.models.Users;
import com.secureapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}

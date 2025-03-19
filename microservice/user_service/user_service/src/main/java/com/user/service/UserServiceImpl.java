package com.user.service;

import com.user.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    //fake list
    List<User> list = List.of(
            new User(1331L, "Om Tiwari", "2324243543"),
            new User(1332L, "Ankit Tiwari", "78564386583"),
            new User(1333L, "Ram Tiwari", "2568735463"));

    @Override
    public User getUser(Long id) {
        return list.stream().filter(user -> user.getUserID().equals(id)).findAny().orElse(null);
    }
}

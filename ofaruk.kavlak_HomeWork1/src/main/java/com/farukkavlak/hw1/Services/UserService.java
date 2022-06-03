package com.farukkavlak.hw1.Services;

import com.farukkavlak.hw1.Models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> findAll();
    User findUserById(int user_id);
    User updateUserById(User newUser,int updatedUser_id);
    User setInactive(int user_id);
}

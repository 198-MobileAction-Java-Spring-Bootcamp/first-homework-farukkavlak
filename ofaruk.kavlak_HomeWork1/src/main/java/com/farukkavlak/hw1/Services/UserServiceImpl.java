package com.farukkavlak.hw1.Services;

import com.farukkavlak.hw1.Models.User;
import com.farukkavlak.hw1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(int user_id) {
        return userRepository.findById(user_id).orElse(null);
    }

    @Override
    public User updateUserById(User newUser, int updatedUser_id) {
        return userRepository.findById(updatedUser_id).map(
                        user -> {
                            user.setActive(newUser.isActive());
                            user.setEmail(newUser.getEmail());
                            user.setBirthDate(newUser.getBirthDate());
                            user.setName(newUser.getName());
                            user.setSurname(newUser.getSurname());
                            user.setPhoneNumber(newUser.getPhoneNumber());
                            return userRepository.save(user);
                        })
                .orElse(null);
    }

    @Override
    public User setInactive(int user_id) {
        User selectedUser = findUserById(user_id);
        selectedUser.setActive(Boolean.FALSE);
        return saveUser(selectedUser);
    }
}

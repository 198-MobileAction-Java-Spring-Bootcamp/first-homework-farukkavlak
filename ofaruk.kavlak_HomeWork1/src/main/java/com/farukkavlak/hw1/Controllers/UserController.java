package com.farukkavlak.hw1.Controllers;

import com.farukkavlak.hw1.Models.User;
import com.farukkavlak.hw1.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("saveUser")
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return user.getName()+" "+ user.getSurname()+" saved";
    }

    @GetMapping("findAllUsers")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("findUserById/{user_id}")
    public User findUserById(@PathVariable("user_id") int user_id){
        return userService.findUserById(user_id);
    }

    @PutMapping("updateUserById/{updatedUser_id}")
    public String updateUserById(@RequestBody User newUser,@PathVariable int updatedUser_id){
        User replacedUser = userService.updateUserById(newUser,updatedUser_id);
        return "User updated(id="+replacedUser.getId()+")";
    }

    @PutMapping("setInactive/{user_id}")
    public String setInactive(@PathVariable("user_id") int user_id){
        User selectedUser = userService.setInactive(user_id);
        return "User is deactivated(id="+selectedUser.getId()+")";
    }
}

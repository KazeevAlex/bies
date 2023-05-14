package com.bies.user.controller;

import com.bies.user.model.User;
import com.bies.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        User user = userService.findById(userId);

        if (user == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        return user;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        user.setId(0);
        User dbUser = userService.save(user);
        return dbUser;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        User dbUser = userService.save(user);
        return dbUser;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        User user = userService.findById(userId);

        if (user == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);

        return "Deleted user id - " + userId;
    }
}

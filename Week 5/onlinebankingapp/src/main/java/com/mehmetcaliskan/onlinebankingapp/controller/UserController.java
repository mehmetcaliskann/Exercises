package com.mehmetcaliskan.onlinebankingapp.controller;

import com.mehmetcaliskan.onlinebankingapp.entity.User;
import com.mehmetcaliskan.onlinebankingapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{tcKimlikNo}")
    public User getUserByTcKimlikNo(@PathVariable String tcKimlikNo) {
        return userService.getByTcKimlikNo(tcKimlikNo);
    }

    @PostMapping("")
    public String saveUser(@Valid @RequestBody User user) {
        if (userService.save(user)) {
            return "User saved successfully";
        } else {
            return "User could not be saved";
        }
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

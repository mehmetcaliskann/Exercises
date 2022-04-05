package com.mehmetcaliskan.onlinebankingapp.service;

import com.mehmetcaliskan.onlinebankingapp.entity.User;
import com.mehmetcaliskan.onlinebankingapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getByTcKimlikNo(String tcKimlikNo) {
        return userRepository.getUserByTcKimlikNo(tcKimlikNo);
    }

    public boolean save(User user) {
        if (user.isPasswordValid()) {
            return userRepository.save(user);
        } else {
            return false;
        }
    }

    public List<User> getAllUsers() {
        return userRepository.getUsers();
    }
}

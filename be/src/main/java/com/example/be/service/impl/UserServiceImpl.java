package com.example.be.service.impl;

import com.example.be.dto.request.UserRequest;
import com.example.be.exception.BadRequestException;
import com.example.be.model.User;
import com.example.be.repository.UserRepository;
import com.example.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserRequest userRequest) {
        return userRepository.save(
                User.builder()
                        .username(userRequest.getUsername())
                        .password(userRequest.getPassword())
                        .build());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BadRequestException("USER", "USER_NOT_FOUND"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, UserRequest user) {
        User userData = userRepository.findById(id).orElseThrow(() -> new BadRequestException("USER", "USER_NOT_FOUND"));
        userData.setPassword(user.getPassword());
        userData.setUsername(user.getUsername());
        return userRepository.save(userData);
    }

    @Override
    public boolean deleteUser(Long id) {
        User userData = userRepository.findById(id).orElseThrow(() -> new BadRequestException("USER", "USER_NOT_FOUND"));
        userRepository.delete(userData);
        return true;
    }
}

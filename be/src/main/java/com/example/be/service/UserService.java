package com.example.be.service;

import com.example.be.dto.request.UserRequest;
import com.example.be.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(UserRequest userRequest);

    User findById(Long id);

    List<User> getAll();

    User updateUser(Long id, UserRequest user);

    boolean deleteUser(Long id);
}

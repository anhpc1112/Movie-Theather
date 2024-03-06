package com.example.be.controller;

import com.example.be.dto.BaseResponseDto;
import com.example.be.dto.request.UserRequest;
import com.example.be.model.User;
import com.example.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public BaseResponseDto<User> getUser(@PathVariable("id") String id) {
        return BaseResponseDto.<User>builder()
                .data(userService.findById(Long.parseLong(id)))
                .build();
    }

    @PostMapping("/create")
    public BaseResponseDto<User> createUser(@RequestBody UserRequest user) {
        return BaseResponseDto.<User>builder()
                .data(userService.saveUser(user))
                .build();
    }

    @GetMapping()
    public BaseResponseDto<List<User>> getAll() {
        return BaseResponseDto.<List<User>>builder()
                .data(userService.getAll())
                .build();
    }

    @PutMapping("/{id}/update")
    public BaseResponseDto<User> updateUser(@PathVariable("id") String id, @RequestBody UserRequest user) {
        return BaseResponseDto.<User>builder()
                .data(userService.updateUser(Long.parseLong(id), user))
                .build();
    }

    @DeleteMapping ("/{id}/delete")
    public BaseResponseDto<?> deleteUser(@PathVariable("id") String id) {
        return BaseResponseDto.builder()
                .data(userService.deleteUser(Long.parseLong(id)))
                .build();
    }
}

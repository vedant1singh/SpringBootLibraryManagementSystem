package com.example.Library.LMS.controller;

import com.example.Library.LMS.entity.Book;
import com.example.Library.LMS.entity.User;
import com.example.Library.LMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/user")
    public List<User> getUser(){
        return  service.getUsers();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User u){
        service.updateUser(u);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
    }

}

package com.example.Library.LMS.service;

import com.example.Library.LMS.entity.Book;
import com.example.Library.LMS.entity.User;
import com.example.Library.LMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public List<User> getUsers(){

        return repo.findAll();
    }

    public void addUser(User user){

        repo.save(user);
    }

    public void updateUser(User u){
        repo.save(u);
    }

    public void deleteUser(Integer id){
        repo.deleteById(id);
    }

}

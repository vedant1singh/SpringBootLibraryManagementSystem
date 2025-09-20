package com.example.Library.LMS.controller;

import com.example.Library.LMS.entity.Transaction;
import com.example.Library.LMS.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService service;
    @PostMapping("/issue")
    public Transaction issueBook(@RequestParam Integer userId, @RequestParam Integer bookId){
        return service.issueBook(userId, bookId);
    }

    @PostMapping("/return")
    public Transaction returnBook(@RequestParam Integer transactionId){
        return service.returnBook(transactionId);
    }





}

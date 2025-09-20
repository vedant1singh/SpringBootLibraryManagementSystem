package com.example.Library.LMS.controller;

import com.example.Library.LMS.entity.Book;
import com.example.Library.LMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class BookController {
    @Autowired
    BookService service;

    @GetMapping("/books")
    public List<Book> getBooks(){

        return service.getBooks();
    }
    @PostMapping("/books")
    public void addBook(@RequestBody Book b){
        service.addBook(b);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book b){
        service.updateBook(b);
    }
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id){
        service.deleteBook(id);
    }
}

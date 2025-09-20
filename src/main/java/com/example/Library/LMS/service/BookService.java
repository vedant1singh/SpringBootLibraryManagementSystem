package com.example.Library.LMS.service;

import com.example.Library.LMS.entity.Book;
import com.example.Library.LMS.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repo;

    public List<Book> getBooks(){

        return repo.findAll();
    }

    public void addBook(Book b){

        repo.save(b);
    }

    public void updateBook(Book b){
        repo.save(b);
    }

    public void deleteBook(Integer id){
        repo.deleteById(id);
    }

}

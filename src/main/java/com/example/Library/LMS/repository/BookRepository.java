package com.example.Library.LMS.repository;

import com.example.Library.LMS.entity.Book;
import com.example.Library.LMS.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


}

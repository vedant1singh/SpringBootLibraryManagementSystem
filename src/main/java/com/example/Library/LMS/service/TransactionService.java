package com.example.Library.LMS.service;

import com.example.Library.LMS.entity.Book;
import com.example.Library.LMS.entity.Transaction;
import com.example.Library.LMS.entity.User;
import com.example.Library.LMS.repository.BookRepository;
import com.example.Library.LMS.repository.TransactionRepository;
import com.example.Library.LMS.repository.UserRepository;
import com.example.Library.LMS.entity.TransactionStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionrepo;

    @Autowired
    BookRepository bookrepo;

    @Autowired
    UserRepository userrepo;




    public Transaction issueBook(Integer userId, Integer bookId) {
        //Fetch User
        User user = userrepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found" + userId ));

        //Fetch Book
        Book book = bookrepo.findById(bookId).orElseThrow(() -> new RuntimeException(("Book not found" + bookId)));

        if (book.getAvailable_Copies() <= 0) {
            throw new RuntimeException("No copies available for this book!");
        }
        Transaction transaction = new Transaction();

        transaction.setUser(user);
        transaction.setBook(book);
        transaction.setIssueDate(LocalDate.now());
        transaction.setDueDate(LocalDate.now().plusDays(14)); // 2 weeks borrowing
        transaction.setFine(0.0);
        transaction.setStatus(TransactionStatus.ISSUED);
        book.setAvailable_Copies(book.getAvailable_Copies() - 1);
        bookrepo.save(book);
        return transactionrepo.save(transaction);
    }

    public Transaction returnBook(Integer transactionId){
        Transaction transaction = transactionrepo.findById(transactionId).orElseThrow(() -> new RuntimeException("Transaction not found" + transactionId ));
        transaction.setReturnDate(LocalDate.now());
        Book book = transaction.getBook();
        book.setAvailable_Copies(book.getAvailable_Copies() + 1);
        bookrepo.save(book);

        if(transaction.getDueDate().isBefore(LocalDate.now())){
            long daysLate = ChronoUnit.DAYS.between(transaction.getDueDate(), LocalDate.now());
            double fine = daysLate *10.0;
            transaction.setFine(fine);
        }

        transaction.setStatus(TransactionStatus.RETURNED);
        return transactionrepo.save(transaction);

    }





}

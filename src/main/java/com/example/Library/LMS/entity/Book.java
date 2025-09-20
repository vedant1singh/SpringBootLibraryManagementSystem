package com.example.Library.LMS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private String isbn;
    private Integer total_Copies;
    private Integer available_Copies;

    public Book() {
    }

    public Book(Integer book_id, String title, String author, String publisher, String category, String isbn, Integer total_Copies, Integer available_Copies) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.isbn = isbn;
        this.total_Copies = total_Copies;
        this.available_Copies = available_Copies;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getTotal_Copies() {
        return total_Copies;
    }

    public void setTotal_Copies(Integer total_Copies) {
        this.total_Copies = total_Copies;
    }

    public Integer getAvailable_Copies() {
        return available_Copies;
    }

    public void setAvailable_Copies(Integer available_Copies) {
        this.available_Copies = available_Copies;
    }
}

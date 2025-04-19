package com.book.domain;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Introspected
@Serdeable
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String title;
    private String author;
    private String subject;
    private String isbn;
    private int pages;
    @DateCreated
    private Date createdDate;
    @DateUpdated
    private Date updatedDate;

    public Book(Long id, String title, String author, String subject, String isbn, int pages, Date createdDate, Date updatedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.isbn = isbn;
        this.pages = pages;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
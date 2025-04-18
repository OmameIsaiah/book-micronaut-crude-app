package com.book.domain;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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

    public Book(Long id, String title, String author, String subject, String isbn, int pages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.isbn = isbn;
        this.pages = pages;
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
}
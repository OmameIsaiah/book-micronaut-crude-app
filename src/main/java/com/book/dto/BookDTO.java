package com.book.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;

@Introspected
@Serdeable
public class BookDTO implements Serializable {
    private String title;
    private String author;
    private String subject;
    private String isbn;
    private int pages;

    public BookDTO(String title, String author, String subject, String isbn, int pages) {
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.isbn = isbn;
        this.pages = pages;
    }

    public BookDTO() {
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

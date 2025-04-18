package com.book.service.Impl;

import com.book.domain.Book;
import com.book.dto.ApiResponse;
import com.book.dto.BookDTO;
import com.book.repository.BookRepository;
import com.book.service.BookService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.*;


@Singleton
public class BookServiceImpl implements BookService {
    @Inject
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public HttpResponse<ApiResponse> saveBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setSubject(bookDTO.getSubject());
        book.setIsbn(bookDTO.getIsbn());
        book.setPages(bookDTO.getPages());
        Book b = bookRepository.save(book);
        return HttpResponse.created(
                new ApiResponse<>(true,
                        HttpStatus.CREATED.getCode(),
                        HttpStatus.CREATED,
                        "Awesome! Book added successfully!",
                        b)
        );
    }

    @Override
    public HttpResponse<ApiResponse> findById(Long id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isPresent()) {
            return HttpResponse.ok(
                    new ApiResponse<>(true,
                            HttpStatus.OK.getCode(),
                            HttpStatus.OK,
                            "Awesome! Book retrieved successfully!",
                            optional.get())
            );
        }
        return HttpResponse.notFound(
                new ApiResponse<>(false,
                        HttpStatus.NOT_FOUND.getCode(),
                        HttpStatus.NOT_FOUND,
                        "Oops! No book found with the id: " + id)
        );
    }

    @Override
    public HttpResponse<ApiResponse> findAll() {
        List<Book> list = bookRepository.findAll();

        if (!list.isEmpty()) {
            return HttpResponse.ok(
                    new ApiResponse<>(true,
                            HttpStatus.OK.getCode(),
                            HttpStatus.OK,
                            "Awesome! Book(s) retrieved successfully!",
                            list)
            );
        }
        return HttpResponse.ok(
                new ApiResponse<>(false,
                        HttpStatus.OK.getCode(),
                        HttpStatus.OK,
                        "Oops! No books found in the library.")
        );
    }
}

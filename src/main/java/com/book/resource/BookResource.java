package com.book.resource;

import com.book.dto.ApiResponse;
import com.book.dto.BookDTO;
import com.book.service.BookService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

@Controller("/api/v1")
public class BookResource {

    @Inject
    private BookService bookService;

    @Get(value = "/book", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ApiResponse> findById(@QueryValue Long id) {
        return bookService.findById(id);
    }

    @Get(value = "/book/{id}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ApiResponse> findByIdPathVariable(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @Get(value = "/books", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ApiResponse> findAll() {
        return bookService.findAll();
    }

    @Post(value = "/book", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ApiResponse> saveBook(@Body BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }
}
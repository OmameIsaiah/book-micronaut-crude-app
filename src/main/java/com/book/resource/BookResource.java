package com.book.resource;

import com.book.dto.ApiResponse;
import com.book.dto.BookDTO;
import com.book.service.BookService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;

@Controller("/api/v1")
public class BookResource {

    @Inject
    private BookService bookService;


    @Get(value = "/book", produces = MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Find a bok by id",
            description = "Resource to find a book by id"
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(type = "string")
            )
    )
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "400",
            description = "Bad request supplied. Id not an integer value")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "404",
            description = "Book not found with the id")
    @Tag(name = "findById")
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
package com.book.service;

import com.book.dto.ApiResponse;
import com.book.dto.BookDTO;
import io.micronaut.http.HttpResponse;

public interface BookService {
    HttpResponse<ApiResponse> saveBook(BookDTO bookDTO);

    HttpResponse<ApiResponse> findById(Long id);

    HttpResponse<ApiResponse> findAll();
}

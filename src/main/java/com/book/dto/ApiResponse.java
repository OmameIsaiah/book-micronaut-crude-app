package com.book.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpStatus;
import io.micronaut.serde.annotation.Serdeable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Introspected
@Serdeable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {
    private Boolean success;
    private Integer code;
    private HttpStatus status;
    private String message;
    private T data = (T) new ArrayList<>();
    private Map<String, Object> meta = new HashMap<>();

    public Map<String, Object> getMeta() {
        return meta;
    }

    public ApiResponse addMeta(String key, Object value) {
        meta.put(key, value);
        return this;
    }

    public ApiResponse() {
    }

    public ApiResponse(Boolean success, Integer code, T data) {
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public ApiResponse(Boolean success, Integer code, HttpStatus status, T data) {
        this.success = success;
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public ApiResponse(Boolean success, Integer code, HttpStatus status, String message) {
        this.success = success;
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public ApiResponse(Boolean success, Integer code, HttpStatus status, String message, T data) {
        this.success = success;
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }
}
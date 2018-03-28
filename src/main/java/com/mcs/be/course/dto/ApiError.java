package com.mcs.be.course.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ApiError implements Serializable{

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Collections.singletonList(error);
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

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiError apiError = (ApiError) o;

        if (getStatus() != apiError.getStatus()) return false;
        if (getMessage() != null ? !getMessage().equals(apiError.getMessage()) : apiError.getMessage() != null)
            return false;
        return getErrors() != null ? getErrors().equals(apiError.getErrors()) : apiError.getErrors() == null;
    }

    @Override
    public int hashCode() {
        int result = getStatus() != null ? getStatus().hashCode() : 0;
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getErrors() != null ? getErrors().hashCode() : 0);
        return result;
    }
}


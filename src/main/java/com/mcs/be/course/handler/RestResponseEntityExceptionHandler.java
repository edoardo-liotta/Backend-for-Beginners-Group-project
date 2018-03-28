package com.mcs.be.course.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mcs.be.course.dto.ApiError;
import com.mcs.be.course.exception.ElementNotFound;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ElementNotFound.class)
    protected @ResponseBody ResponseEntity<Object> handleElementNotFound(ElementNotFound ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND,ex.getMessage(), ex.getClass().getName());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = IllegalStateException.class)
    protected @ResponseBody ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.CONFLICT,ex.getMessage(), ex.getClass().getName());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
    @ExceptionHandler(value = IllegalArgumentException.class)
    protected @ResponseBody ResponseEntity<Object> handleIllegalArgument(RuntimeException ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST,ex.getMessage(), ex.getClass().getName());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

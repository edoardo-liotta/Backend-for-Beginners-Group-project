package com.mcs.be.course.handler;

import com.mcs.be.course.dto.ApiError;
import com.mcs.be.course.exception.ElementNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    //TODO additional: handle ElementNotFound exception returning a 200 Http Status and a custom message

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected @ResponseBody ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        ApiError error = new ApiError(HttpStatus.CONFLICT,ex.getMessage(), ex.getClass().getName());
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}

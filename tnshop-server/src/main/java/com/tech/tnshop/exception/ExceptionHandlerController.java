package com.tech.tnshop.exception;

import com.tech.tnshop.dto.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Locale;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {
    @Qualifier("messageSource")
    private final MessageSource msgSource;

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<Object> handlerInternalServerException(InternalServerException ex, WebRequest request) {
        //Log error
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handlerNotFoundException(NotFoundException ex, WebRequest request) {
        //Log error
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handlerNotUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        //Log error
        ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handlerBadRequestException(BadRequestException ex, WebRequest request) {
        //Log error
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SqlException.class)
    public ResponseEntity<Object> handlerSqlException(SqlException ex, WebRequest request) {
        //Log error
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerException(Exception ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> processValidateError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        String message = "";
        for (FieldError error : fieldErrors) {
            String temp = processFieldError(error);
            message += temp + " ; ";
        }
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, message);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    private String processFieldError(FieldError error) {
        String msg = "";
        if (error != null) {
            Locale currentLocale = LocaleContextHolder.getLocale();
            try {
                msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
            } catch (Exception e) {
                msg = error.getDefaultMessage();
            }
        }
        return msg;
    }
}

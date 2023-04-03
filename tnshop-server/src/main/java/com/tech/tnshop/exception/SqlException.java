package com.tech.tnshop.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SqlException extends DataIntegrityViolationException {
    public SqlException(String message) {
        super(message);
    }
}

package com.tech.tnshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JwtExpiredException extends RuntimeException {

    public JwtExpiredException( String message) {
        super(message);
    }

}

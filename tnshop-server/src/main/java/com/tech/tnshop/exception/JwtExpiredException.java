package com.tech.tnshop.exception;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JwtExpiredException extends ExpiredJwtException {

    public JwtExpiredException(Header header, Claims claims, String message) {
        super(header, claims, message);
    }

    public JwtExpiredException(Header header, Claims claims, String message, Throwable cause) {
        super(header, claims, message, cause);
    }
}

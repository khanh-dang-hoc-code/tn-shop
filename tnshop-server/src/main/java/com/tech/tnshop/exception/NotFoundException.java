package com.tech.tnshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException  extends  RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}

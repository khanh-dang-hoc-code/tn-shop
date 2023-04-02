package com.tech.tnshop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorResponse {
    private HttpStatus status;
    private String message;
}

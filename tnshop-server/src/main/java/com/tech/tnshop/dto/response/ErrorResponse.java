package com.tech.tnshop.dto.response;


import lombok.*;
import org.springframework.http.HttpStatus;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private HttpStatus statusCode;
    private String message;
}

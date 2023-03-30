package com.tech.tnshop.dto.response;


import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private HttpStatus statusCode;
    private String message;
}

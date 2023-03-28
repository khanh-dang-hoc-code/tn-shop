package com.tech.tnshop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbstractResponse  {
    private HttpStatusCode statusCode;
    private Object response;
}

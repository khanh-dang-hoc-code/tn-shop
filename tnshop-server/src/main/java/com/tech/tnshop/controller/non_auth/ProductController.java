package com.tech.tnshop.controller.non_auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/non-auth/product")
public class ProductController {
    @GetMapping
    public ResponseEntity<Object> getAllProduct() {
        return ResponseEntity.ok("Products");
    }
}

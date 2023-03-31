package com.tech.tnshop.controller.non_auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${no-auth}/category")
public class CategoryController {

    @GetMapping
    public ResponseEntity<Object> getAllCategory() {
        return ResponseEntity.ok("Categories");
    }
}

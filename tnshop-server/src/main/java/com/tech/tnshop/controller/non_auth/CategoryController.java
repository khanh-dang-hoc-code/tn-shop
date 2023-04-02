package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${no-auth}/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping("/get")
    public ResponseEntity<Object> getCategory(@RequestParam String categoryId) {
        return categoryService.getCategoryByID(categoryId);
    }

    @GetMapping("/get-list")
    public ResponseEntity<Object> getListCategory(@RequestParam int index, @RequestParam int limit) {
        return categoryService.getAllCategory(index, limit);
    }
}

package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.service.serviceImpl.ProductServiceImpl;
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
@RequiredArgsConstructor
@RequestMapping("${no-auth}/product")
public class ProductController {

    private final ProductServiceImpl productService;


    @GetMapping("/get-list")
    public ResponseEntity<Object> getAllProduct(@RequestParam int index, @RequestParam int limit,
                                                @RequestParam String brandId, @RequestParam String categoryId,
                                                @RequestParam String sortByPrice, @RequestParam String sortByCreateDate) {
        return ResponseEntity.ok(new AbstractResponse(productService.getAllProducts(index, limit, brandId, categoryId, sortByPrice, sortByCreateDate)));
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getALlProducts(@RequestParam String productId) {
        return productService.getProduct(productId);
    }
}

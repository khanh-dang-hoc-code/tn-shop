package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.service.impl.ProductServiceImpl;
import jakarta.validation.constraints.NotNull;
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
    public ResponseEntity<Object> getAllProduct(@RequestParam String categoryId, @RequestParam  String brandId,
                                                @RequestParam @NotNull int index, @RequestParam @NotNull  int limit, @RequestParam  String sortByName,
                                                @RequestParam  String sortByPrice, @RequestParam  String sortByCreateDate,
                                                @RequestParam  String saleEventId, @RequestParam  String color, @RequestParam  String size ) {
        return productService.getAllProducts(categoryId, brandId, index, limit, sortByName, sortByPrice, sortByCreateDate, saleEventId,color, size);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getALlProducts(@RequestParam String productId) {
        return productService.getProduct(productId);
    }
}

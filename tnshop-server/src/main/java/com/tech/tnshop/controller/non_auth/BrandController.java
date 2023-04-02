package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.service.impl.BrandServiceImpl;
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
@RequestMapping("${no-auth}/brand")
public class BrandController {

    private final BrandServiceImpl brandService;

    @GetMapping("/get")
    public ResponseEntity<Object> getBrandById(@RequestParam String brandId) {
        return brandService.getBrand(brandId);
    }

    @GetMapping("/get-list")
    public ResponseEntity<Object> getListBrand(@RequestParam int index, @RequestParam int limit) {
        return brandService.getAllBrands(index, limit);
    }
}

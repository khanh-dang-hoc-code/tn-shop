package com.tech.tnshop.controller.non_auth;

import com.tech.tnshop.dto.response.AbstractResponse;
import com.tech.tnshop.service.serviceImpl.BrandServiceImpl;
import com.tech.tnshop.shop_enum.SortEnum;
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

    @GetMapping
    public ResponseEntity<Object> getAllBrand(@RequestParam int index, @RequestParam int limit) {
        return ResponseEntity.ok(new AbstractResponse(brandService.getAllBrands(index, limit)));
    }
}

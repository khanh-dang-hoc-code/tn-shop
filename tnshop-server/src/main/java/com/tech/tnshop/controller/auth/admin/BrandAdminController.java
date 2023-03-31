package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.dto.request.brand.AddNewBrandRequest;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.service.serviceImpl.BrandServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${admin-auth}/brand")
@RequiredArgsConstructor
public class BrandAdminController {

    private final BrandServiceImpl brandService;

    @PostMapping("/add")
    public ResponseEntity<Object> addNewBrand(@RequestBody AddNewBrandRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        return brandService.addNewBrand(request);
    }
}

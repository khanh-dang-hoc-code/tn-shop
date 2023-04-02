package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.dto.request.brand.AddNewBrandRequest;
import com.tech.tnshop.dto.request.brand.UpdateBrandRequest;
import com.tech.tnshop.dto.request.product.RemoveListProductRequest;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.service.serviceImpl.BrandServiceImpl;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
@RestController
@RequestMapping("${admin-auth}/brand")
@RequiredArgsConstructor
public class AdminBrandController {

    private final BrandServiceImpl brandService;

    @GetMapping("/get")
    public ResponseEntity<Object> getBrandById(@RequestParam String brandId) {
        return brandService.getBrand(brandId);
    }

    @GetMapping("/get-list")
    public ResponseEntity<Object> getListBrand(@RequestParam int index, @RequestParam int limit) {
        return brandService.getAllBrands(index, limit);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewBrand(@RequestBody AddNewBrandRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        return brandService.addNewBrand(request);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateBrand(@RequestBody UpdateBrandRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        return brandService.updateBrand(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteBrand(@RequestParam @NotNull String brandId) {
        return brandService.deleteBrand(brandId);
    }

    @DeleteMapping("/delete-list")
    public ResponseEntity<Object> deleteListBrand(@RequestBody RemoveListProductRequest request) {
        return brandService.removeListBrand(request.getIds());
    }
}

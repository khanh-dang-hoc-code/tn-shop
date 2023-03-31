package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.dto.request.brand.AddNewBrandRequest;
import com.tech.tnshop.dto.request.product.AddNewProductRequest;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.service.serviceImpl.ProductServiceImpl;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${admin-auth}/product")
@RequiredArgsConstructor
public class ProductAdminController {

    private final ProductServiceImpl productService;

    @GetMapping
    public ResponseEntity<Object> getALlProducts(@RequestParam @NotNull int index, @RequestParam @NotNull int limit) {
        System.out.println("Correct");
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewProduct(@RequestBody AddNewProductRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        return productService.addNewProduct(request);
    }
}

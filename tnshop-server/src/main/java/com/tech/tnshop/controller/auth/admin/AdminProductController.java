package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.dto.request.product.AddNewProductRequest;
import com.tech.tnshop.dto.request.product.RemoveListProductRequest;
import com.tech.tnshop.dto.request.product.UpdateProductRequest;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.service.impl.ProductServiceImpl;
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
@RequestMapping("${admin-auth}/product")
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductServiceImpl productService;

    @GetMapping("/get-list")
    public ResponseEntity<Object> getALlProducts(@RequestParam String categoryId, @RequestParam  String brandId,
                                                 @RequestParam @NotNull int index, @RequestParam @NotNull  int limit, @RequestParam  String sortByName,
                                                 @RequestParam  String sortByPrice, @RequestParam  String sortByCreateDate,
                                                 @RequestParam  String saleEventId, @RequestParam  String color, @RequestParam  String size ) {
        return productService.getAllProducts(categoryId, brandId, index, limit, sortByName, sortByPrice, sortByCreateDate, saleEventId, color, size);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getALlProducts(@RequestParam String productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewProduct(@RequestBody AddNewProductRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        return productService.addNewProduct(request);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateProduct(@RequestBody UpdateProductRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        return productService.updateProduct(request);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteProduct(@RequestParam String productId) {
        return productService.deleteProduct(productId);
    }

    @DeleteMapping("/delete-list")
    public ResponseEntity<Object> deleteListProduct(@RequestBody RemoveListProductRequest request) {
        return productService.removeListProduct(request.getIds());
    }

}

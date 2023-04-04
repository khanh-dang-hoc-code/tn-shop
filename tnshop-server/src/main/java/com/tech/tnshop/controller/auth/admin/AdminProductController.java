package com.tech.tnshop.controller.auth.admin;

import com.tech.tnshop.dto.request.product.AddNewProductRequest;
import com.tech.tnshop.dto.request.product.RemoveListProductRequest;
import com.tech.tnshop.dto.request.product.UpdateProductRequest;
import com.tech.tnshop.exception.BadRequestException;
import com.tech.tnshop.helper.ShopHelper;
import com.tech.tnshop.helper.StringHelper;
import com.tech.tnshop.service.impl.ProductServiceImpl;
import com.tech.tnshop.shop_enum.ColorEnum;
import com.tech.tnshop.shop_enum.SizeEnum;
import com.tech.tnshop.shop_enum.SortEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
    public ResponseEntity<Object> getALlProducts(@RequestParam(required = false) String categoryId, @RequestParam(required = false)  String brandId,
                                                 @RequestParam int index, @RequestParam  int limit, @RequestParam(required = false)  String sortByName,
                                                 @RequestParam(required = false) String sortByPrice, @RequestParam(required = false)  String sortByCreateDate,
                                                 @RequestParam(required = false)  String saleEventId, @RequestParam(required = false)  String color, @RequestParam(required = false)  String size ) {
        if (StringHelper.isNotEmpty(sortByCreateDate) && !SortEnum.validateSortType(sortByCreateDate)) {
            throw new BadRequestException("sortByCreateDate params is not valid");
        }
        if (StringHelper.isNotEmpty(color) && !ColorEnum.validateColor(color)) {
            throw new BadRequestException("color params is not valid");
        }
        if (StringHelper.isNotEmpty(size) && !SizeEnum.validateSize(size)) {
            throw new BadRequestException("size params is not valid");
        }
        if (StringHelper.isNotEmpty(sortByPrice) && !SortEnum.validateSortType(sortByPrice)) {
            throw new BadRequestException("sortByPrice params is not valid");
        }
        if (StringHelper.isNotEmpty(sortByName) && !SortEnum.validateSortType(sortByName)) {
            throw new BadRequestException("sortByName params is not valid");
        }
        return productService.getAllProducts(categoryId, brandId, index, limit, sortByName, sortByPrice, sortByCreateDate, saleEventId, color, size);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getALlProducts(@RequestParam String productId) {
        return productService.getProduct(productId);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addNewProduct(@RequestBody AddNewProductRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        if (!SizeEnum.validateSize(request.getSize()) || !ColorEnum.validateColor(request.getColor())) {
            throw new BadRequestException("Color or size params is not valid");
        }
        return productService.addNewProduct(request);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateProduct(@RequestBody UpdateProductRequest request) {
        ShopHelper.validateObjectRequiredFields(request);
        if (StringHelper.isNotEmpty(request.getSize()) && !SizeEnum.validateSize(request.getSize())
                || StringHelper.isNotEmpty(request.getColor()) && !ColorEnum.validateColor(request.getColor())) {
            throw new BadRequestException("Color or size params is not valid");
        }
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

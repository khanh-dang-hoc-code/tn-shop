package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.product.AddNewProductRequest;
import com.tech.tnshop.entity.Product;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public class ProductMapper {
    public static Product mapToProduct(AddNewProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .priceSold(request.getPriceSold())
                .build();
    }
}

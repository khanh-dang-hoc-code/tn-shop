package com.tech.tnshop.dto.mapper;

import com.tech.tnshop.dto.request.brand.AddNewBrandRequest;
import com.tech.tnshop.entity.Brand;
import com.tech.tnshop.dto.request.BrandRequest;
import com.tech.tnshop.dto.response.BrandResponse;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public class BrandMapper {
    public static Brand mapToBrand(AddNewBrandRequest request) {
        return Brand.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public static BrandResponse mapToBrandResponse(Brand brand) {
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .description(brand.getDescription())
                .createDate(brand.getCreateDate())
                .build();
    }
}

package com.tech.tnshop.dto.mapper;

/*
 * @created 02/04/2023 - 17:43
 * @project tn-shop
 * @author  ngockhanh
 */

import com.tech.tnshop.dto.request.category.AddNewCategoryRequest;
import com.tech.tnshop.entity.Category;

public class CategoryMapper {
    private CategoryMapper() {

    }
    public static Category mapToCategoryEntity(AddNewCategoryRequest request) {
        return Category.builder()

                .build();
    }
}

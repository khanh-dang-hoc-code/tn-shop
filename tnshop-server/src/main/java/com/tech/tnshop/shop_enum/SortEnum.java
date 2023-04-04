package com.tech.tnshop.shop_enum;

import com.tech.tnshop.exception.BadRequestException;

import java.util.Arrays;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public enum SortEnum {
    DESC("DESC"),
    ASC("ASC");
    private final String sortType;

    public static boolean validateSortType(String sortType) {
        return Arrays.stream(values())
                .filter(s -> s.sortType.equalsIgnoreCase(sortType))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Order status " + sortType + " is not valid")) != null;
    }

    SortEnum(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return sortType;
    }

}

package com.tech.tnshop.shop_enum;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public enum SortEnum {
    DESC("DESC"),
    ASC("ASC");
    private String sortType;

    SortEnum(String sortType) {
        this.sortType = sortType;
    }

    public String getSortType() {
        return sortType;
    }

}

package com.tech.tnshop.shop_enum;

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

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}

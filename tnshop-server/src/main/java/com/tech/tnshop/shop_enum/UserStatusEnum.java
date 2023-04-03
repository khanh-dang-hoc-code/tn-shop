package com.tech.tnshop.shop_enum;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public enum UserStatusEnum {

    ACTIVE("active"),
    PENDING("pending"),
    DISABLE("disable");

    private final String status;

    UserStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}

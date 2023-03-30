package com.tech.tnshop.shop_enum;

public enum UserStatusEnum {

    ACTIVE("active"),
    PENDING("pending"),
    DISABLE("disable");

    public String status;

    UserStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}

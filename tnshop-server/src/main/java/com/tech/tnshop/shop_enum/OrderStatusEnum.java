package com.tech.tnshop.shop_enum;

import lombok.Data;

public enum OrderStatusEnum {
    PENDING("pending"),
    PROCESSING("processing"),
    SHIPPED("shipped"),
    DELIVERED("delivered"),
    CANCELLED("canceled");

    public String name;

    OrderStatusEnum(String name) {
        this.name = name;
    }
}

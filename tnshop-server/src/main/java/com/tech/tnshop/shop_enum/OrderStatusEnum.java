package com.tech.tnshop.shop_enum;

import com.tech.tnshop.exception.BadRequestException;
import lombok.Data;

import java.util.Arrays;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public enum OrderStatusEnum {
    PENDING("pending"),
    PROCESSING("processing"),
    SHIPPED("shipped"),
    DELIVERED("delivered"),
    CANCELLED("canceled");

    public String name;

    public static boolean validateOrderStatus(String orderStatus) {
        return Arrays.stream(values())
                .filter(s -> s.name().equalsIgnoreCase(orderStatus))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Order status " + orderStatus + " is not valid")) != null;
    }

    OrderStatusEnum(String name) {
        this.name = name;
    }
}

package com.tech.tnshop.shop_enum;

import com.tech.tnshop.exception.BadRequestException;

import java.util.Arrays;

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

    public static boolean validateUserStatus(String status) {
        return Arrays.stream(values())
                .filter(s -> s.status.equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Order status " + status + " is not valid")) != null;
    }

    UserStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}

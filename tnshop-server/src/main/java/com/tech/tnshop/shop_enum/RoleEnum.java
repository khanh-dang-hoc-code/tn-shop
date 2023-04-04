package com.tech.tnshop.shop_enum;

import com.tech.tnshop.exception.BadRequestException;

import java.util.Arrays;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public enum RoleEnum {

    USER_ROLE("USER"),
    ADMIN_ROLE("ADMIN"),
    ANONYMOUS_ROLE("anonymous_role");

    public final String role;
    public static boolean validateRole(String role) {
        return Arrays.stream(values())
                .filter(s -> s.role.equalsIgnoreCase(role))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Order status " + role + " is not valid")) != null;
    }

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

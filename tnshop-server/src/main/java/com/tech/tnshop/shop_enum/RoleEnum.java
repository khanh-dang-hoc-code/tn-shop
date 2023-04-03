package com.tech.tnshop.shop_enum;

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

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

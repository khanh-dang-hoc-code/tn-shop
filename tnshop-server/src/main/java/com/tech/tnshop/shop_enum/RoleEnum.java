package com.tech.tnshop.shop_enum;

public enum RoleEnum {

    USER_ROLE("USER"),
    ADMIN_ROLE("ADMIN"),
    ANONYMOUS_ROLE("anonymous_role");

    public String name;

    RoleEnum(String name) {
        this.name = name;
    }
}

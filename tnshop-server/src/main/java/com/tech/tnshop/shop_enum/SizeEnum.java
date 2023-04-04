package com.tech.tnshop.shop_enum;

import com.tech.tnshop.exception.BadRequestException;

import java.util.Arrays;

public enum SizeEnum {
    S("s"),
    L("l"),
    X("x"),
    XL("xl"),
    XLL("xll"),
    SIZE_39("39"),
    SIZE_40("40"),
    SIZE_41("41"),
    SIZE_42("42"),
    SIZE_43("43"),
    SIZE_44("44"),
    SIZE_45("45"),
    SIZE_46("46");

    private final String size;

    public static boolean validateSize(String size) {
        return Arrays.stream(values())
                .filter(s -> s.size.equalsIgnoreCase(size))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Order status " + size + " is not valid")) != null;
    }

    SizeEnum(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}

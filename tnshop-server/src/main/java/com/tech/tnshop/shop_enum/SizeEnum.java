package com.tech.tnshop.shop_enum;

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

    SizeEnum(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}

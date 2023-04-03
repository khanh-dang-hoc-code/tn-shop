package com.tech.tnshop.shop_enum;

public enum ColorEnum {
    RED("red"),
    BLUE("blue"),
    BLACK("black"),
    WHITE("white"),
    GREEN("green");
    private final String color;
    ColorEnum(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}

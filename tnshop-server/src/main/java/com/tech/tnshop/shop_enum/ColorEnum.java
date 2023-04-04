package com.tech.tnshop.shop_enum;

import com.tech.tnshop.exception.BadRequestException;

import java.util.Arrays;

public enum ColorEnum {
    RED("red"),
    BLUE("blue"),
    BLACK("black"),
    WHITE("white"),
    GREEN("green");
    private final String color;

    public static boolean validateColor(String color) {
        return Arrays.stream(values())
                .filter(s -> s.color.equalsIgnoreCase(color))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("color " + color + " is not valid")) != null;
    }
    ColorEnum(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}

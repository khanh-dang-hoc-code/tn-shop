package com.tech.tnshop.shop_enum;

import com.tech.tnshop.exception.BadRequestException;

import java.util.Arrays;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public enum PaymentStatusEnum {
    SUCCESS("success"),
    PENDING("pending"),
    REQUIRED_ACTION("required_action"),
    ERROR("error"),
    CANCEL("cancel");

    private final String code;

    public static boolean validatePaymentStatus(String paymentStatus) {
        return Arrays.stream(values())
                .filter(s -> s.code.equalsIgnoreCase(paymentStatus))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Order status " + paymentStatus + " is not valid")) != null;
    }

    PaymentStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}

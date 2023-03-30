package com.tech.tnshop.shop_enum;

public enum PaymentStatusEnum {
    SUCCESS("success"),
    PENDING("pending"),
    REQUIRED_ACTION("required_action"),
    ERROR("error"),
    CANCEL("cancel");

    private String code;

    PaymentStatusEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

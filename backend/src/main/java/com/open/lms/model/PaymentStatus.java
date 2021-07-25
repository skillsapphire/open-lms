package com.open.lms.model;

public enum PaymentStatus {
    PROCESSED("Processed"),
    DECLINED("Declined");

    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

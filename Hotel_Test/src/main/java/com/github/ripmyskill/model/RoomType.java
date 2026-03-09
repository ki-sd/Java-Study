package com.github.ripmyskill.model;

public enum RoomType {
    SINGLE(55000), DOUBLE(80000), DELUXE(100000), SUITE(150000);

    private final long defaultPrice;

    RoomType(long defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public long getDefaultPrice() {
        return defaultPrice;
    }
}

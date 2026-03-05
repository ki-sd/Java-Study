package model;

public enum RoomType {
    Single(55000), Double(80000), Deluxe(100000), Suite(150000);

    private final long defaultPrice;

    RoomType(long defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public long getDefaultPrice() {
        return defaultPrice;
    }
}

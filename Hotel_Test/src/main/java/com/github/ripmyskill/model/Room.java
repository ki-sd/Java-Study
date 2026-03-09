package com.github.ripmyskill.model;

import java.text.DecimalFormat;

public class Room {
    private int roomNo;
    private RoomType roomType;
    private long roomPrice;
    private RoomStatus roomStatus;

    public Room (int roomNo, RoomType roomType){
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomPrice = roomType.getDefaultPrice();
        this.roomStatus = RoomStatus.AVAILABLE;
    }
    public String getFormattedPrice() {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(this.roomPrice) + "원";
    }
    public boolean isBookingAvailable() {
        return this.roomStatus == RoomStatus.AVAILABLE;
    }

    // --- Getter & Setter ---

    public int getRoomNo() {
        return roomNo;
    }

    public long getRoomPrice() {
        return roomPrice;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}



package com.github.ripmyskill.model;

import java.time.LocalDateTime;

public class ReservationData {
    private String id;
    private String userId;
    private int roomNumber;
    private LocalDateTime date;

    public ReservationData() {}

    public ReservationData(Reservation res) {
        this.id = res.getReservationId();
        this.userId = res.getUser().getUserId();
        this.roomNumber = res.getRoom().getRoomNo();
        this.date = res.getReserveDate();
    }

    public String getId() {
        return id;
    }
    public String getUserId() {
        return userId;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public LocalDateTime getDate() {
        return date;
    }
}

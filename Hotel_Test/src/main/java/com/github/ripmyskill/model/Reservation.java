package com.github.ripmyskill.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private String reservationId;
    private User user;
    private Room room;
    private String reserveDate;

    public Reservation(String reservationId, User user, Room room, String reserveDate) {
        this.reservationId = reservationId;
        this.user = user;
        this.room = room;
        this.reserveDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public String getReservationId() {
        return reservationId;
    }
    public User getUser() {
        return user;
    }
    public Room getRoom() {
        return room;
    }
    public String getReserveDate() {
        return reserveDate;
    }
}

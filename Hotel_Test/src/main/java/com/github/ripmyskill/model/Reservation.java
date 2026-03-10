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

    //예약정보
    public String getInfo() {
        String formattedPrice = String.format("%, d", room.getRoomPrice());

        return String.format(
                "------------------------------------\n" +
                "1. 예약자 성함 : %s\n" +
                "2. 예약하신 객실 : %d호 (%s)\n" +
                "3. 예약 번호   : %s\n" +
                "4. 예약하신 시간 : %s\n" +
                "5. 결제하실 금액 : %s원\n" +
                "------------------------------------",
                user.getName(),
                room.getRoomNo(),
                room.getRoomType(),
                reservationId,
                reserveDate,
                formattedPrice
        );
    }



    // Getter / Setter
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

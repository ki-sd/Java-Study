package com.github.ripmyskill.service;

import com.github.ripmyskill.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.Color.*;
import static org.fusesource.jansi.Ansi.ansi;

public class HotelService {

    private Map<Integer, Room> rooms;

    public HotelService() {
        rooms = new TreeMap<>();
        initializeRooms();
    }

    private void initializeRooms() {
        RoomType[] types = {RoomType.SINGLE, RoomType.DOUBLE, RoomType.DELUXE, RoomType.SUITE};
        for(int i=1; i<=4; i++) {
            RoomType type = types[i - 1];
            for (int j = 1; j <= 6; j++) {
                int roomNumber = i * 100 + j;
                rooms.put(roomNumber, new Room(roomNumber, type));
            }
        }

        }

    //객실 정보
    public void showRoomGrid() {
        System.out.println("\n"+"=".repeat(102));
        System.out.println(" ".repeat(43)+"호텔 객실 현황판");
        System.out.println("=".repeat(102));

        int currentFloor = 0;

        for (Room room : rooms.values()) {
            int floor = room.getRoomNo() / 100;

            if (floor != currentFloor) {
                if (currentFloor != 0) System.out.println();
                System.out.println(ansi().fg(WHITE).bold().a(floor + "F | ").reset());
                currentFloor = floor;
            }

            Ansi roomAnsi = ansi();
            String statusLabel;

            switch (room.getRoomStatus()) {
                case AVAILABLE -> {
                    roomAnsi.fg(GREEN);
                    statusLabel = "빈방";
                }
                case OCCUPIED -> {
                    roomAnsi.fg(RED);
                    statusLabel = "만실";
                }
                case CLEANING -> {
                    roomAnsi.fg(YELLOW);
                    statusLabel = "청소중";
                }
                default -> {
                    roomAnsi.fg(DEFAULT);
                    statusLabel = "확인";
                }
            }

            String roomInfo = String.format("%d:%s(%s)", room.getRoomNo(), room.getRoomType(), statusLabel);
            System.out.print(roomAnsi.a(String.format("%-16s", roomInfo)).reset());
        }

        System.out.println("\n"+"=".repeat(102));
        System.out.println("상태: " +
                ansi().fg(GREEN).a("예약가능 ").reset() +
                ansi().fg(RED).a("예약됨 ").reset() +
                ansi().fg(YELLOW).a("청소중").reset());
        System.out.println("=".repeat(102));
    }
    private Map<String, Reservation> reservations = new HashMap<>();

    //예약
    public void reserveRoom(int roomNo, User user) {
        Room room = rooms.get(roomNo);

        if (room == null) {
            System.err.println("존재하지 않는 객실 번호입니다.");
            return;
        }
        if (room.getRoomStatus() != RoomStatus.AVAILABLE) {
            System.out.println("이미 예약되었거나 사용 불가능한 객실입니다.");
            return;
        }

        String rId = "R" + System.currentTimeMillis();
        Reservation newReservation = new Reservation(rId, user, room, null);

        reservations.put(rId, newReservation);
        room.setRoomStatus(RoomStatus.OCCUPIED);

        System.out.println(ansi().fg(GREEN).a(roomNo+"번 객실의 예약이 완료되었습니다.").fg(CYAN).a(" 예약번호:"+rId).reset());

    }

    //예약 정보
    public void showMyReservations(User currentUser) {
        System.out.println(ansi().fg(CYAN).a("\n[ "+ currentUser.getName() + "님의 예약 내역 ]").reset());

        boolean hasReservation = false;
        for (Reservation res : reservations.values()) {
            if (res.getUser().getUserId().equals(currentUser.getUserId())) {
                System.out.println(res.getInfo());
                hasReservation = true;
            }
        }
        if (!hasReservation)
            System.out.println("예약 내역이 없습니다.");
    }

    //예약 취소
    public boolean cancelReservations(String rId, User currentUser) {
        Reservation res = reservations.get(rId);

        if(!isOwner(res, currentUser)) {
            System.out.println(ansi().fg(RED).a("[error] 해당 예약 번호를 찾을 수 없습니다.").reset());
            return false;
        }

        res.getRoom().setRoomStatus(RoomStatus.AVAILABLE);
        reservations.remove(rId);
        return true;
    }

    private boolean isOwner(Reservation res, User currentUser) {
        if(res == null || currentUser==null) return false;
        return res.getUser().getUserId().equals(currentUser.getUserId());
    }

    public Room findRoom(int roomNo) {
        return rooms.get(roomNo);
    }

    public Map<Integer, Room> getRooms() {
        return rooms;
    }
}
